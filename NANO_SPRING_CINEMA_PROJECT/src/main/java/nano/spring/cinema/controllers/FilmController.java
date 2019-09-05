/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.controllers;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nano.spring.cinema.entities.Film;
import nano.spring.cinema.repositories.FilmRepository;
import nano.spring.cinema.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
@Controller
public class FilmController {
    
    private static final Logger LOG = Logger.getLogger(AccountController.class.getName());
    
    @Autowired
    private FilmRepository filmRepository;
    
    @RequestMapping(value = "current-films", method = RequestMethod.GET)
    public ModelAndView getFilms(){
        ModelAndView model = new ModelAndView("film-list");
        Date currentDate = new Date(System.currentTimeMillis());
        List<Film> films = filmRepository.findCurrentFilms(currentDate);
        model.addObject("films", films);
        model.addObject("current", true);
        LOG.log(Level.INFO, "get current films");
        
        return model;
    }
    
    @RequestMapping(value = "to-be-out-films", method = RequestMethod.GET)
    public ModelAndView getToBeOutFilms(){
        ModelAndView m = new ModelAndView("film-list");
        Date currentDate = new Date(System.currentTimeMillis());
        List<Film> films = filmRepository.findToBeOutFilms(currentDate);
        m.addObject("films", films);
        LOG.log(Level.INFO, "get to be out films");
        return m;
    }
    
    @RequestMapping(value = "film-detail", method = RequestMethod.POST)
    public String getFilmDetailById(@RequestParam(value = "id") long id, ModelMap m){
        Film film = filmRepository.findOne(id);
        m.addAttribute("film", film);
        Date currentDate = new Date(System.currentTimeMillis());
        if (!film.getFromDate().after(currentDate)) {
            m.addAttribute("current", true);
        }
        String video = film.getVideo();
        int pos = video.lastIndexOf("youtube.com/");
        pos += "youtube.com/".length();
        video = StringUtils.insertString(video, pos, "embed/");
        video = video.replace("watch?v=", "");
        film.setVideo(video);
        LOG.log(Level.INFO, "film id: " + id + " - film name: " + film.getName());
        return "film-detail";
    }
}
