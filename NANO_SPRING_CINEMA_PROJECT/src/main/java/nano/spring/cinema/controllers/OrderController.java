/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.controllers;

import nano.spring.cinema.entities.TimeTable;
import nano.spring.cinema.repositories.FilmRepository;
import nano.spring.cinema.repositories.OrderRepository;
import nano.spring.cinema.repositories.TimeTableRepository;
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
public class OrderController {
    
    @Autowired
    private OrderRepository orderRepository; 
    @Autowired
    private FilmRepository filmRepository;        
    @Autowired
    private TimeTableRepository timeTableRepository;
    
    @RequestMapping(value = "/form-order", method = RequestMethod.GET)
    public String getFormOrder(ModelMap model){
        model.addAttribute("films", filmRepository.findAll());
        model.addAttribute("timetables", timeTableRepository.findAll());
        return "order-book-main";
    }
        
    @RequestMapping(value = "/form-order-room", method = RequestMethod.POST)
    public String getFormOrderRoom(ModelMap model){
        return "order-book-phase-2";
    }        
}
