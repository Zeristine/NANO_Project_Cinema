/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import nano.spring.cinema.entities.OrderFilm;
import nano.spring.cinema.entities.Ticket;
import nano.spring.cinema.entities.TimeTable;
import nano.spring.cinema.repositories.FilmRepository;
import nano.spring.cinema.repositories.OrderRepository;
import nano.spring.cinema.repositories.ShowTimeRepository;
import nano.spring.cinema.repositories.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private ShowTimeRepository showTimeRepository;

    @RequestMapping(value = "/form-order", method = RequestMethod.GET)
    public String getFormOrder(ModelMap model) {
        model.addAttribute("films", filmRepository.findAll());
        return "order-book-main";
    }
    
    @RequestMapping(value = "/form-order-room", method = RequestMethod.POST)
    public String getFormOrderRoom(
            ModelMap model,
            @RequestParam(value = "id") long id
    ) {
        OrderFilm o = new OrderFilm();
        o.setOrderDate(Calendar.getInstance().getTime());
        o.setShowTime(showTimeRepository.findOne(id));        
        o.setTickets(new HashSet<Ticket>());
        model.addAttribute("order", orderRepository.save(o));
        return "order-book-phase-2";
    }

    @RequestMapping(value = "/order-remove", method = RequestMethod.POST)
    public @ResponseBody
    String removeOrder(@RequestParam(value = "id") long id) {
        if (orderRepository.exists(id)) {
            orderRepository.delete(id);
            if (orderRepository.exists(id)) {
                return "fail";
            } else {
                return "success";
            }
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/order-tickets-save", method = RequestMethod.POST)
    public String saveOrderTickets(){
        return "";
    }
    
    @RequestMapping(value = "/form-order-date", method = RequestMethod.POST)
    public String getShowDateOfFilm(
            ModelMap model,
            @RequestParam(value = "id") long id
    ) {
        model.addAttribute("timetables", showTimeRepository.findByFilmId(id));
        return "order-book-phase-1-part";
    }
}
