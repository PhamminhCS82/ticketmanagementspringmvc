/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.formatter;

import com.group11.pojos.Route;
import com.group11.pojos.Seat;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author LocNe
 */
public class RouteFormatter implements org.springframework.format.Formatter<Seat> {

    @Override
    public String print(Seat t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Seat parse(String cateId, Locale locale) throws ParseException {
        Seat c = new Seat();
        c.setId(Integer.parseInt(cateId));
        return c;
    }

}
