/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.formatter;

import com.group11.pojos.User;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author LocNe
 */
public class UserFormatter implements org.springframework.format.Formatter<User>{

    @Override
    public String print(User t, Locale locale) {
      return String.valueOf(t.getId());
    }

    @Override
    public User parse(String string, Locale locale) throws ParseException {
         User c = new User();

        c.setId(Integer.parseInt(string));
        return c;
    }
    
}
