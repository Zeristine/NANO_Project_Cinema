/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import nano.spring.cinema.entities.Account;
import nano.spring.cinema.entities.OrderFilm;
import nano.spring.cinema.entities.Point;
import nano.spring.cinema.entities.Ticket;
import nano.spring.cinema.repositories.AccountRepository;
import nano.spring.cinema.repositories.OrderFilmRepository;
import nano.spring.cinema.repositories.PointRepository;
import nano.spring.cinema.utils.DBConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HaAnh
 */
@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private PointRepository pointRepo;

    @Autowired
    private OrderFilmRepository orderFilmRepo;

    private static final Logger LOG = Logger.getLogger(AccountController.class.getName());

    @RequestMapping(value = "/form-register", method = RequestMethod.GET)
    public String registerPage() {
        return "register";
    }

    @RequestMapping(value = "/form-login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/form-change-password-{id}", method = RequestMethod.GET)
    public String changePasswordPage(@PathVariable("id") Long id, ModelMap model) {
        Account account = accountRepo.findOne(id);
        model.addAttribute("account", account);
        return "change-password";
    }

    @RequestMapping(value = "/form-update-profile-{id}", method = RequestMethod.GET)
    public String updateProfilePage(@PathVariable("id") Long id, ModelMap model) {
        Account account = accountRepo.findOne(id);
        model.addAttribute("account", account);
        return "update-profile";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String birthdate,
            @RequestParam(required = false) String phone) {
        ModelAndView m = new ModelAndView("register");
        try {
            Account acc = new Account();
            acc.setUsername(username);
            acc.setPassword(password);
            acc.setFirstname(firstname);
            acc.setLastname(lastname);
            acc.setBirthdate(Date.valueOf(birthdate));
            acc.setPhone(phone);
            if (accountRepo.findByUsername(username).size() > 0) {
                m.addObject("msg", "Username exists, please choose another!");
            } else {
                accountRepo.save(acc);
                m.addObject("success", true);
            }
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    String login(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password
    ) {
        Account logged = accountRepo.findByUsernameAndPassword(username, password);
        if (logged == null) {
            return "fail";
        } else {
            return logged.getFirstname() + " " + logged.getLastname() + "-" + logged.getId();
        }
    }

    @RequestMapping(value = "/account-profile-{id}", method = RequestMethod.GET)
    public String getProfile(ModelMap model, @PathVariable(value = "id") long id) {
        Account account = accountRepo.findOne(id);
        model.addAttribute("account", account);
        LOG.log(Level.INFO, "user name: " + account.getUsername());
        Integer point = pointRepo.getTotalPointByAccountId(id);
        if (point == null) {
            point = 0;
        }
        model.addAttribute("totalPoint", point);
        LOG.log(Level.INFO, "Total point: " + point);
        return "account-profile";
    }

    @RequestMapping(value = "change-password", method = RequestMethod.POST)
    public String changePassword(ModelMap model,
            @RequestParam(value = "id") long id,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "oldPassword") String oldPassword,
            @RequestParam(value = "newPassword") String newPassword,
            @RequestParam(value = "retype") String retype) {
        Account account = accountRepo.findByUsernameAndPassword(username, oldPassword);
        String msg = null;
        if (account == null) {
            msg = "Wrong password, try again";
            LOG.log(Level.INFO, username + ": Wrong password");
            account = accountRepo.findOne(id);
        } else {
            if (!newPassword.equals(retype)) {
                msg = "Password and retype must match";
            } else {
                newPassword = newPassword.trim();
                account.setPassword(newPassword);
                accountRepo.save(account);
                msg = "Update password successfully!";
                LOG.log(Level.INFO, username + ": Change password successfully");
            }
        }
        model.addAttribute("msg", msg);
        model.addAttribute("account", account);
        return "change-password";
    }

    @RequestMapping(value = "/update-profile", method = RequestMethod.POST)
    public String updateProfile(
            @RequestParam Long id,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String birthdate,
            @RequestParam(required = false) String phone,
            ModelMap m) {
        String msg = null;
        Account acc = accountRepo.findOne(id);
        try {
            Date birth = Date.valueOf(birthdate);
            acc.setFirstname(firstname);
            acc.setLastname(lastname);
            acc.setBirthdate(birth);
            acc.setPhone(phone);
            accountRepo.save(acc);
            msg = "Update profile successfully!";
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            msg = "Error occur!";
        }
        m.addAttribute("msg", msg);
        m.addAttribute("account", acc);
        return "update-profile";
    }

    @RequestMapping(value = "/form-manage-order", method = RequestMethod.POST)
    public String getFormOrder(@RequestParam("accountId") Long accountId,
            ModelMap model) {
        System.out.println("ACCOUNT ID " + accountId);
        List<OrderFilm> orders = orderFilmRepo.findByAccountId(accountId);
        Account account = accountRepo.findOne(accountId);
        model.addAttribute("orders", orders);
        model.addAttribute("account", account);
        return "manage-order";
    }

    @RequestMapping(value = "/cancel-order", method = RequestMethod.POST)
    public String cancelOrder(@RequestParam("id") Long id,
            @RequestParam("accountId") Long accountId,
            ModelMap model) {
        System.out.println("ACCOUNT ID " + accountId);
        OrderFilm order = orderFilmRepo.findOne(id);
        Account account = accountRepo.findOne(accountId);
        try {
            Set<Ticket> tickets = order.getTickets();
            if (tickets != null && !tickets.isEmpty()) {
                Point p = new Point(-DBConstants.POINT_PER_TICKET * tickets.size(), account);
                pointRepo.save(p);
            }
            order.setStatus(DBConstants.ORDERFILM_STATUS_CANCELED);
            orderFilmRepo.save(order);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return "forward:/form-manage-order";
    }
}
