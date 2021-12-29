/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.formatter;

import com.group11.pojos.Route;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author LocNe
 */

public class RouteFormatter implements org.springframework.format.Formatter<Route>{

 


    @Override
    public String print(Route t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override

    public Route parse(String cateId, Locale locale) throws ParseException {
         Route c = new Route();

        c.setId(Integer.parseInt(cateId));
        return c;
    }

}
