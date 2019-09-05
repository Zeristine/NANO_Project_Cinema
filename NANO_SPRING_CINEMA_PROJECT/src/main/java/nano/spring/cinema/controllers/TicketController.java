/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.controllers;

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
public class TicketController {

    @Autowired
    private TimeTableRepository timeTableRepository;
    
    @RequestMapping(value = "/ticket-price", method = RequestMethod.GET)
    public String getTicketPrice(
            ModelMap model
    ) {
        model.addAttribute("prices", timeTableRepository.findAll());
        return "ticket-price";
    }

}
