/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.controllers;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import nano.spring.cinema.entities.Account;
import nano.spring.cinema.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HaAnh
 */

@Controller
public class AccountController {
    
    @Autowired
    private AccountRepository accountRepo;
    
    private static final Logger LOG = Logger.getLogger(AccountController.class.getName());
    
    @RequestMapping(value = "form-register", method = RequestMethod.GET)
    public String registerPage() {
        return "register";
    }
    
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam(required = false) String username,
                                @RequestParam(required = false) String password,
                                @RequestParam(required = false) String firstname,
                                @RequestParam(required = false) String lastname,
                                @RequestParam(required = false) String birthdate,
                                @RequestParam(required = false) String phone){
        ModelAndView m = new ModelAndView("register");
        try {
            Account acc = new Account();
            acc.setUsername(username);
            acc.setPassword(password);
            acc.setFirstname(firstname);
            acc.setLastname(lastname);
            acc.setBirthdate(Date.valueOf(birthdate));
            acc.setPhone(phone);
            accountRepo.save(acc);
            m.addObject("success", true);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            String msg = "Error occur!";
            if (e.getMessage().contains("UNIQUE KEY")) {
                msg = "Username exists, please choose another!";
            }
            m.addObject("msg", msg);
        }
        return m;
    }
}
