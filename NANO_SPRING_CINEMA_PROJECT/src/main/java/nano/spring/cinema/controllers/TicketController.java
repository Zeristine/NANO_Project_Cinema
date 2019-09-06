/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nano.spring.cinema.entities.TimeTable;
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
        Map<String, List<String>> priceMap = new HashMap<>();
        List<TimeTable> list = timeTableRepository.findAll();

        for (TimeTable timeTable : list) {
            String weekDay = timeTable.getStartWeekDay() + "-" + timeTable.getEndWeekDay();
            String startEndPrice = timeTable.getStartTime() + "-" + timeTable.getEndTime() + "|" + timeTable.getPrice();
            if (checkExistKey(priceMap, weekDay).isEmpty()) {
                priceMap.put(weekDay, new ArrayList<String>());
            }
            priceMap.get(weekDay).add(startEndPrice);
        }
        model.addAttribute("prices", priceMap);
        return "ticket-price";
    }

    private String checkExistKey(Map<String, List<String>> priceMap, String key) {
        for (Map.Entry<String, List<String>> entry : priceMap.entrySet()) {
            String key1 = entry.getKey();
            if (key.equals(key1)) {
                return key1;
            }
        }
        return "";
    }

}
