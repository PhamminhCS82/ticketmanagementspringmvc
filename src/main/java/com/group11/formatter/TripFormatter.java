/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.formatter;

import com.group11.pojos.Trip;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author LocNe
 */
public class TripFormatter implements org.springframework.format.Formatter<Trip>{

    @Override
    public String print(Trip t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Trip parse(String string, Locale locale) throws ParseException {
         Trip c = new Trip();

        c.setId(Integer.parseInt(string));
        return c;
    }
    
}
