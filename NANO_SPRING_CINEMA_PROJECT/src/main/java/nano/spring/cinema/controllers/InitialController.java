/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import nano.spring.cinema.entities.Category;
import nano.spring.cinema.entities.Company;
import nano.spring.cinema.entities.Film;
import nano.spring.cinema.entities.FilmPersonRole;
import nano.spring.cinema.entities.TimeTable;
import nano.spring.cinema.repositories.AccountRepository;
import nano.spring.cinema.repositories.CategoryRepository;
import nano.spring.cinema.repositories.CompanyRepository;
import nano.spring.cinema.repositories.FilmRepository;
import nano.spring.cinema.repositories.OrderRepository;
import nano.spring.cinema.repositories.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author admin
 */
@Controller
public class InitialController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private TimeTableRepository timeTableRepository;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String toHomePage() {
        if (filmRepository.count() == 0) {
            createData();
        }
        return "home";
    }

    private void createData() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Film f = new Film();
        f.setName("The Avengers");
        f.setImage("https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX182_CR0,0,182,268_AL_.jpg");
        f.setCategories(new HashSet<Category>());
        f.setDuration(120);
        f.setDescription("The heros gather around...");
        f.setVideo("https://www.youtube.com/watch?v=eOrNdBpGMv8");
        f.setPersonrole(new HashSet<FilmPersonRole>());
        f.setFromDate(new Date());
        f.setToDate(new Date());
        f = filmRepository.save(f);
        Company c = new Company();
        c.setName("Marvel Studio");
        f.setCompany(companyRepository.save(c));
        addCategory("Action", f);
        addCategory("Horror", f);
        addCategory("Adventure", f);
        addCategory("Comedy", f);
        filmRepository.save(f);
        Film f2 = new Film();
        f2.setName("The Avengers: End Game");
        f2.setImage("https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_.jpg");
        f2.setCategories(new HashSet<Category>());
        f2.setDuration(120);
        f2.setDescription("The heros gather around...");
        f2.setVideo("https://www.youtube.com/watch?v=TcMBFSGVi1c");
        f2.setPersonrole(new HashSet<FilmPersonRole>());
        f2.setFromDate(new Date());
        f2.setToDate(new Date());
        f2 = filmRepository.save(f2);        
        f2.setCompany(companyRepository.save(c));        
        filmRepository.save(f2);
        try {
            TimeTable tt = new TimeTable();
            tt.setStartWeekDay(2);
            tt.setEndWeekDay(6);
            tt.setStartTime(sdf.parse("24:00:00"));
            tt.setEndTime(sdf.parse("23:59:59"));
            tt.setPrice(100000);
            timeTableRepository.save(tt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void addCategory(String categoryname, Film f) {
        Category c = new Category();
        c.setName(categoryname);
        f.getCategories().add(categoryRepository.save(c));
    }
}
