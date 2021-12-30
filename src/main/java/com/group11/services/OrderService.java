/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services;

import com.group11.pojos.OrderTicket;
import com.group11.pojos.Ticket;
import com.group11.pojos.Tickets;
import com.group11.pojos.User;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author pminh
 */
public interface OrderService {
    boolean addOrder(Tickets ticket);
    boolean addOnlineOrder(Tickets tickets, BigDecimal amount, String onlinePayId);
    OrderTicket getOrderById(int id);
    List<OrderTicket> getOrderByUser(User user);
    List<Ticket> getOrderDetailByOrder(OrderTicket order);
}
