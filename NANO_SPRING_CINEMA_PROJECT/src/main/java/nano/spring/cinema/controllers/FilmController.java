/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import nano.spring.cinema.entities.Category;
import nano.spring.cinema.entities.Film;
import nano.spring.cinema.entities.FilmPersonRole;
import nano.spring.cinema.repositories.FilmRepository;
import nano.spring.cinema.utils.DBConstants;
import nano.spring.cinema.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping(value = "/current-films", method = RequestMethod.GET)
    public ModelAndView getFilms(){
        ModelAndView model = new ModelAndView("film-list");
        Date currentDate = new Date(System.currentTimeMillis());
//        List<Film> films = filmRepository.findCurrentFilms(currentDate);
        model.addObject("films", filmRepository.findAll());
        model.addObject("current", true);
        LOG.log(Level.INFO, "get current films");
        
        return model;
    }
    
    @RequestMapping(value = "/to-be-out-films", method = RequestMethod.GET)
    public ModelAndView getToBeOutFilms(){
        ModelAndView m = new ModelAndView("film-list");
        Date currentDate = new Date(System.currentTimeMillis());
        List<Film> films = filmRepository.findToBeOutFilms(currentDate);
        m.addObject("films", films);
        LOG.log(Level.INFO, "get to be out films");
        return m;
    }
    
    @RequestMapping(value = "/film-detail-{id}", method = RequestMethod.GET)
    public String getFilmDetailById(@PathVariable(value = "id") long id, ModelMap m){
        Film film = filmRepository.findOne(id);
        m.addAttribute("film", film);
        Date currentDate = new Date(System.currentTimeMillis());
        if (!film.getFromDate().after(currentDate)) {
            m.addAttribute("current", true);
        }
        //video url
        String video = film.getVideo();
        int pos = video.lastIndexOf("youtube.com/");
        pos += "youtube.com/".length();
        video = StringUtils.insertString(video, pos, "embed/");
        video = video.replace("watch?v=", "");
        film.setVideo(video);
        //actor & director
        Set<FilmPersonRole> roles = film.getPersonrole();
        if (roles != null && roles.size() > 0) {
            String actors = "";
            String director = "";
            for (FilmPersonRole role : roles) {
                if (role.getRole() != null) {
                    if (role.getRole().getName().equals(DBConstants.ROLE_ACTOR)) {
                        actors += role.getPerson().getName() + ", ";
                    } else if (role.getRole().getName().equals(DBConstants.ROLE_DIRECTOR)) {
                        director += role.getPerson().getName();
                    } 
                }
            }
            actors = actors.trim();
            actors = actors.substring(0, actors.length()-1);
            m.addAttribute("director", director);
            m.addAttribute("actors", actors);
        }
        // categories
        Set<Category> categories = film.getCategories();
        if (categories != null && !categories.isEmpty()) {
            String categoriesStr = "";
            for (Category category : categories) {
                categoriesStr += category.getName() + ", ";
            }
            categoriesStr = categoriesStr.trim();
            m.addAttribute("categories", categoriesStr.substring(0, categoriesStr.length() - 1));
        }
        LOG.log(Level.INFO, "film id: " + id + " - film name: " + film.getName());
        return "film-detail";
    }
    
    @RequestMapping(value = "/search-film", method = RequestMethod.POST)
    public String searchFilmsByName(
            @RequestParam(value = "name") String name,
            ModelMap m
    ){
        List<Film> films = filmRepository.findFilmsByName(name.trim());
        List<Film> currentFilms = new ArrayList<>();
        List<Film> toBeOutFilms = new ArrayList<>();
        Date currentDate = new Date(System.currentTimeMillis());
        for (Film film : films) {
            if (film.getFromDate().after(currentDate)) {
                toBeOutFilms.add(film);
            } else {
                currentFilms.add(film);
            }
        }
        m.addAttribute("films", currentFilms);
        m.addAttribute("current", true);
        m.addAttribute("toBeOutFilms", toBeOutFilms);
        m.addAttribute("search", name);
        LOG.log(Level.INFO, "search value: " + name);
        return "film-list";
    }
}
