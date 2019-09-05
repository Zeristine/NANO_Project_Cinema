/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.controllers;

import nano.spring.cinema.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author admin
 */
@Controller
public class FilmController {
    
    @Autowired
    private FilmRepository filmRepository;
    
    @RequestMapping(value = "films", method = RequestMethod.POST)
    public String getFilms(ModelMap model){
        model.addAttribute("films", filmRepository.findAll());
        return "film-list";
    }
    
}
