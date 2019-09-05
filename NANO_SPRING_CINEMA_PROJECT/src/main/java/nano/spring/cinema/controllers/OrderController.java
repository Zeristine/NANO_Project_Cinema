/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.controllers;

import nano.spring.cinema.repositories.FilmRepository;
import nano.spring.cinema.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    
    @RequestMapping(value = "/form-order", method = RequestMethod.GET)
    public String getFormOrder(){
        return "order-book-main";
    }
    
}
