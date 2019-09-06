/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import nano.spring.cinema.entities.Account;
import nano.spring.cinema.entities.Category;
import nano.spring.cinema.entities.Company;
import nano.spring.cinema.entities.Film;
import nano.spring.cinema.entities.FilmPersonRole;
import nano.spring.cinema.entities.Room;
import nano.spring.cinema.entities.ShowTime;
import nano.spring.cinema.entities.TimeTable;
import nano.spring.cinema.repositories.AccountRepository;
import nano.spring.cinema.repositories.CategoryRepository;
import nano.spring.cinema.repositories.CompanyRepository;
import nano.spring.cinema.repositories.FilmRepository;
import nano.spring.cinema.repositories.OrderRepository;
import nano.spring.cinema.repositories.RoomRepository;
import nano.spring.cinema.repositories.ShowTimeRepository;
import nano.spring.cinema.repositories.TimeTableRepository;
import nano.spring.cinema.utils.DateUtils;
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
    private TimeTableRepository timeTableRepository;
    @Autowired
    private ShowTimeRepository showTimeRepository;
    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String toHomePage() {
        if (filmRepository.count() == 0) {
            createData();
        }
        if (accountRepository.count() == 0) {
            initAccounts();
        }
        return "home";
    }

    private void createData() {
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
        addCategory("Action");
        addCategory("Horror");
        addCategory("Adventure");
        addCategory("Comedy");
        f.getCategories().addAll(categoryRepository.findAll());
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
        f2.getCategories().addAll(categoryRepository.findAll());
        f2.setCompany(companyRepository.save(c));
        filmRepository.save(f2);
        addTimeTable(2, 4, "6:00:00", "9:59:59", 100000);
        addTimeTable(2, 4, "10:00:00", "11:59:59", 120000);
        addTimeTable(2, 4, "12:00:00", "16:59:59", 150000);
        addTimeTable(2, 4, "17:00:00", "19:59:59", 200000);
        addTimeTable(2, 4, "20:00:00", "23:59:59", 180000);
        addTimeTable(2, 4, "24:00:00", "5:59:59", 50000);
        addTimeTable(5, 6, "6:00:00", "9:59:59", 50000);
        addTimeTable(5, 6, "10:00:00", "11:59:59", 100000);
        addTimeTable(5, 6, "12:00:00", "16:59:59", 120000);
        addTimeTable(5, 6, "17:00:00", "19:59:59", 150000);
        addTimeTable(5, 6, "20:00:00", "23:59:59", 120000);
        addTimeTable(5, 6, "24:00:00", "5:59:59", 30000);
        addTimeTable(7, 1, "6:00:00", "9:59:59", 120000);
        addTimeTable(7, 1, "10:00:00", "11:59:59", 150000);
        addTimeTable(7, 1, "12:00:00", "16:59:59", 180000);
        addTimeTable(7, 1, "17:00:00", "19:59:59", 200000);
        addTimeTable(7, 1, "20:00:00", "23:59:59", 180000);
        addTimeTable(7, 1, "24:00:00", "5:59:59", 100000);
        addShowTime(f);
        addShowTime(f);
        addShowTime(f2);
        addShowTime(f2);
        addShowTime(f2);
    }

    private void addCategory(String categoryname) {
        Category c = new Category();
        c.setName(categoryname);
        categoryRepository.save(c);
    }

    private void addTimeTable(int start, int end, String startTime, String endTime, double price) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            TimeTable tt = new TimeTable();
            tt.setStartWeekDay(start);
            tt.setEndWeekDay(end);
            tt.setStartTime(sdf.parse(startTime));
            tt.setEndTime(sdf.parse(endTime));
            tt.setPrice(price);
            timeTableRepository.save(tt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void addShowTime(Film f){
        ShowTime st = new ShowTime();
        Room r = new Room();
        r.setIsAvailable(true);
        st.setRoom(roomRepository.save(r));
        st.setShowDate(new Date());
        st.setTicketPrice(10000);
        st.setFilm(f);        
        showTimeRepository.save(st);
    }
    
    private void initAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("haanh", "123456", "Ha Anh", "Nguyen",
                DateUtils.getDateInstance(1, 7, 1997),
                "0123456789", "https://i.pinimg.com/originals/30/88/e1/3088e1abbefe13a1754bd56deafcde2d.jpg"));
        accountRepository.save(accounts);
    }
}
