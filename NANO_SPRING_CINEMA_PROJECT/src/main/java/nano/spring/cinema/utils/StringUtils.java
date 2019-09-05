/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nano.spring.cinema.utils;

import java.util.logging.Logger;

/**
 *
 * @author HaAnh
 */
public class StringUtils {
    
    private static final Logger LOG = Logger.getLogger(StringUtils.class.getName());
    
    public static String insertString(String src, int pos, String inserted) {
        StringBuilder builder = new StringBuilder(src);
        builder.insert(pos, inserted);
        LOG.info(src + ":\n" + builder.toString());
        return builder.toString();
    }
}
