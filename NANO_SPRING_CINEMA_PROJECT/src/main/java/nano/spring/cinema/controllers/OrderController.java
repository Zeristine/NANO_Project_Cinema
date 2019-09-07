/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.controllers;

import java.util.Calendar;
import java.util.StringTokenizer;
import nano.spring.cinema.entities.OrderFilm;
import nano.spring.cinema.entities.ShowTime;
import nano.spring.cinema.entities.Ticket;
import nano.spring.cinema.repositories.AccountRepository;
import nano.spring.cinema.repositories.FilmRepository;
import nano.spring.cinema.repositories.OrderRepository;
import nano.spring.cinema.repositories.ShowTimeRepository;
import nano.spring.cinema.repositories.TicketRepository;
import nano.spring.cinema.utils.DBConstants;
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
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TicketRepository ticketRepository;

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
        ShowTime st = showTimeRepository.findOne(id);
        model.addAttribute("showTime", st);        
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

    @RequestMapping(value = "/order-book-confirm", method = RequestMethod.POST)
    public String toConfirmPhase(
            ModelMap model,
            @RequestParam(value = "id") long stId,
            @RequestParam(value = "seats") String seatStr
    ) {
        model.addAttribute("showtime", showTimeRepository.findOne(stId));
        model.addAttribute("seats", seatStr);
        return "order-book-phase-3";
    }

    @RequestMapping(value = "/order-save", method = RequestMethod.POST)
    public @ResponseBody
    String saveOrderTickets(
            @RequestParam(value = "stId") long stId,
            @RequestParam(value = "aId") long aId,
            @RequestParam(value = "seats") String seatStr
    ) {
        try {
            OrderFilm o = new OrderFilm();
            o.setAccount(accountRepository.findOne(aId));
            o.setShowTime(showTimeRepository.findOne(stId));
            o.setStatus(DBConstants.ORDERFILM_STATUS_BOOKED);
            o.setOrderDate(Calendar.getInstance().getTime());
            orderRepository.save(o);
            for (StringTokenizer st = new StringTokenizer(seatStr, "|"); st.hasMoreTokens();) {
                String token = st.nextToken();
                addSelectedSeat(token, o);
            }
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @RequestMapping(value = "/form-order-date", method = RequestMethod.POST)
    public String getShowDateOfFilm(
            ModelMap model,
            @RequestParam(value = "id") long id
    ) {
        model.addAttribute("timetables", showTimeRepository.findByFilmId(id));
        return "order-book-phase-1-part";
    }

    private void addSelectedSeat(String seat, OrderFilm o) {
        Ticket t = new Ticket();
        t.setOrder(o);
        t.setPointAward(DBConstants.POINT_PER_TICKET);
        t.setPosition(seat);
        t.setStatus(DBConstants.ORDERFILM_STATUS_BOOKED + "");
        ticketRepository.save(t);
    }
}
