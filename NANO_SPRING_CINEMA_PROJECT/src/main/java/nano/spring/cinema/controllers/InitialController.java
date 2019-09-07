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
import nano.spring.cinema.entities.Person;
import nano.spring.cinema.entities.Role;
import nano.spring.cinema.entities.Room;
import nano.spring.cinema.entities.ShowTime;
import nano.spring.cinema.entities.TimeTable;
import nano.spring.cinema.repositories.AccountRepository;
import nano.spring.cinema.repositories.CategoryRepository;
import nano.spring.cinema.repositories.CompanyRepository;
import nano.spring.cinema.repositories.FilmRepository;
import nano.spring.cinema.repositories.OrderRepository;
import nano.spring.cinema.repositories.RoleRepository;
import nano.spring.cinema.repositories.RoomRepository;
import nano.spring.cinema.repositories.ShowTimeRepository;
import nano.spring.cinema.repositories.TimeTableRepository;
import nano.spring.cinema.utils.DBConstants;
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
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String toHomePage() {
        initRoles();
        initPersons();
        initCategories();
        initCompanies();
        initFilms();
        if (filmRepository.count() == 0) {
            createData();
        }
        initAccounts();
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
        if (accountRepository.count() > 0) {
            return;
        }
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("haanh", "123456", "Ha Anh", "Nguyen",
                DateUtils.getDateInstance(1, 7, 1997),
                "0123456789", "https://i.pinimg.com/originals/30/88/e1/3088e1abbefe13a1754bd56deafcde2d.jpg"));
        accountRepository.save(accounts);
    }
    
    private void initRoles() {
        if (roleRepository.count() == 0) {
            Role actor = new Role(DBConstants.ROLE_ACTOR);
            Role director = new Role(DBConstants.ROLE_DIRECTOR);
            List<Role> roles = new ArrayList<>();
            roles.add(actor);
            roles.add(director);
            roleRepository.save(roles);
        }       
    }
     
    private void initPersons() {
        List<Person> persons = new ArrayList<>();
        //weathering with you
        persons.add(new Person("Makoto Shinkai"));
        persons.add(new Person("Nana Mori"));
        persons.add(new Person("Kotaro Daigo"));
        //End game
        persons.add(new Person("Anthony Russo, Joe Russo"));
        persons.add(new Person("Robert Downey Jr."));
        persons.add(new Person("Chris Evans"));
        persons.add(new Person("Mark Ruffalo"));
        persons.add(new Person("Chris Hemsworth"));
        persons.add(new Person("Scarlett Johansson"));
        persons.add(new Person("Jeremy Renner"));
        //MIB-2019
        persons.add(new Person("F. Gary Gray"));
        persons.add(new Person("Tessa Thompson"));
        persons.add(new Person("Kumail Nanjiani"));
        //Doraemon
        persons.add(new Person("Kazuaki Imai"));
        persons.add(new Person("Wasabi Mizuta"));
        persons.add(new Person("Megumi Ohara"));
        persons.add(new Person("Yumi Kakazu"));
        persons.add(new Person("Subaru Kimura"));
        persons.add(new Person("Aoi Yūki"));
    }
    
    private void initCategories() {
        if (categoryRepository.count() > 0) {
            return;
        }
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Anime"));
        categories.add(new Category("Scifi"));
        categories.add(new Category("Horror"));
        categories.add(new Category("Action"));
        categories.add(new Category("Comedy"));
        categories.add(new Category("Adventure"));
        categoryRepository.save(categories);
    }
    
    private void initCompanies() {
        if (companyRepository.count() > 0) {
            return;
        }
        List<Company> companies = new ArrayList<>();
        //Doraemon
        companies.add(new Company("Shin-Ei Animation"));
        //Weathering with you
        companies.add(new Company("CoMix Wave Films Story Inc"));
        companies.add(new Company("Marvel Studios"));
        //MIB-2019
        companies.add(new Company("Columbia Pictures"));
        companyRepository.save(companies);
    }
    
    private void initFilms() {
        if (filmRepository.count() > 0) {
            return;
        }
        List<Film> films = new ArrayList<>();
        //END GAME
        Film endgame = new Film("The Avengers: End Game", 180, 
            DateUtils.getDateInstance(1, 9, 2019), DateUtils.getDateInstance(30, 9, 2019), 
            "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_.jpg", 
            "https://www.youtube.com/watch?v=TcMBFSGVi1c", 
            "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.");
        Company marvel = companyRepository.findByName("Marvel Studios");
        endgame.setCompany(marvel);
        films.add(endgame);
        //MIB
        Film mib = new Film("Men in Black: International", 115, 
            DateUtils.getDateInstance(3, 9, 2019), DateUtils.getDateInstance(3, 10, 2019), 
            "https://is3-ssl.mzstatic.com/image/thumb/Video123/v4/1a/a7/63/1aa7637e-54f9-c4e3-439a-1063e37733e0/pr_source.lsr/268x0w.jpg", 
            "https://www.youtube.com/watch?v=BV-WEb2oxLk", 
            "The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest threat to date: a mole in the Men in Black organization.");
        Company columbia = companyRepository.findByName("Columbia Pictures");
        mib.setCompany(columbia);
        films.add(mib);
        //WEATHER
        Film weather = new Film("Weathering with You", 120, 
            DateUtils.getDateInstance(10, 8, 2019), DateUtils.getDateInstance(20, 9, 2019), 
            "https://m.media-amazon.com/images/M/MV5BYjEzMjJjNzctNmFmMy00MTE4LTkwZTItYjY3Y2VjZmYxNmE3XkEyXkFqcGdeQXVyOTI4MzgyNTk@._V1_.jpg", 
            "https://www.youtube.com/watch?v=Q6iK6DjV_iE", 
            "A high-school boy who has run away to Tokyo befriends a girl who appears to be able to manipulate the weather.");
        Company weatherComp = companyRepository.findByName("CoMix Wave Films Story Inc");
        weather.setCompany(weatherComp);
        films.add(weather);
        //DORAEMON
        Film doreamon = new Film("Doraemon the Movie: Nobita's Treasure Island", 110, 
            DateUtils.getDateInstance(15, 8, 2019), DateUtils.getDateInstance(15, 10, 2019), 
            "https://upload.wikimedia.org/wikipedia/en/thumb/9/9f/Doraemon_movie_2018.jpeg/220px-Doraemon_movie_2018.jpeg", 
            "https://www.youtube.com/watch?v=4TXbUvMHijc", 
            "In the story, Doraemon, Nobita, Shizuka, Gian, and Suneo set out on an adventure in the Caribbean Sea. Nobita is the captain of a ship and fights his enemies on board.");
        Company doreamonComp = companyRepository.findByName("Shin-Ei Animation");
        doreamon.setCompany(doreamonComp);
        films.add(doreamon);
        filmRepository.save(films);
    }
    
//    private void setCategories() {
//        List<Category> list = categoryRepository.findAll();
//        if (list == null || list.isEmpty()) {
//            return;
//        }
////        for (int i = 0; i < list.size(); i++) {
////            if ()
////        }
//    }
}
