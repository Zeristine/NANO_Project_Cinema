/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.utils;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author HaAnh
 */
public class DateUtils {
    public static Date getDateInstance(int d, int m, int y) {
        Calendar cal = Calendar.getInstance();
        cal.set(y, m-1, d);
        return cal.getTime();
    }
}
