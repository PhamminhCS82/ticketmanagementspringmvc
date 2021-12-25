/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.Tickets;
import com.group11.pojos.User;
import com.group11.services.OrderService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pminh
 */
@RestController
public class ApiBuyTicketController {
    @Autowired
    private OrderService orderService;
    
    @PostMapping("/api/pay")
    public HttpStatus pay(@RequestBody Tickets params, HttpSession session) {
        try {
//            User u = (User) session.getAttribute("currentUser");
            if(this.orderService.addOrder(6, params))
                return HttpStatus.OK;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return HttpStatus.BAD_REQUEST;
    }
//    @PostMapping("/api/tickets")
//    public int addToCart(@RequestBody Tickets params, HttpSession session) {
//        Map<Integer, Tickets> tickets = (Map<Integer, Tickets>) session.getAttribute("ticket");
//        if (tickets == null)
//            tickets = new HashMap<>();
//        
//        int seatId = params.getSeatId();
//        if (tickets.containsKey(seatId) == true) { // san pham da co trong gio
//            tickets.remove(seatId);
//        } else { // san pham chua co trong gio
//            tickets.put(seatId, params);
//        }
//        
//        session.setAttribute("ticket", tickets);
//        
//        return tickets.size();
//    }
}
