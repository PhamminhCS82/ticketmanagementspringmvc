/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.utils;

import com.group11.pojos.Seats;
import com.group11.pojos.Ticket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pminh
 */
public class Utils {
    public static Map<String, String> config = new HashMap<String, String>(){{
        put("appid", "2553");
        put("key1", "PcY4iZIKFCIdgZvA6ueMcMHHUbRLYjPL");
        put("key2", "kLtgPl8HHhfvMuDHPwKfgfsY4Ydm9eIz");
        put("endpoint", "https://sbgateway.zalopay.vn/api/getlistmerchantbanks");
    }};

    public static List<Seats> countSeats(int number, Collection<Ticket> collection) {
        List<Seats> result = new ArrayList<>();
        if (!collection.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (Ticket t : collection) {
                list.add(t.getSeatName());
            }

            for (int i = 0; i < number; i++) {
                Seats seat = new Seats();
                seat.setName(i + 1);
                if (list.indexOf(i) < 0) {
                    seat.setBlank(true);
                } else {
                    seat.setBlank(false);
                }
                result.add(seat);
            }
        } else {
            for (int i = 0; i < number; i++) {
                Seats seat = new Seats();
                seat.setName(i + 1);
                seat.setBlank(true);
                result.add(seat);
            }

        }
        result.sort(new Comparator<Seats>() {
            @Override
            public int compare(Seats o1, Seats o2) {
                return o1.getName() - o2.getName();
            }
        });
        return result;
    }
}
