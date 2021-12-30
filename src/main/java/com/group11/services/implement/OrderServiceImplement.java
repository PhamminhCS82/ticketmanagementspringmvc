/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services.implement;

import com.group11.pojos.OrderTicket;
import com.group11.pojos.Ticket;
import com.group11.pojos.Tickets;
import com.group11.pojos.User;
import com.group11.repository.OrderRepository;
import com.group11.services.OrderService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pminh
 */
@Service
public class OrderServiceImplement implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public boolean addOrder(Tickets tickets) {
        return this.orderRepository.addOrder(tickets);
    }
    @Override
    public boolean addOnlineOrder(Tickets tickets, BigDecimal amount, String onlinePayId) {
        return this.orderRepository.addOnlineOrder(tickets, amount, onlinePayId);
    }

    @Override
    public List<OrderTicket> getOrderByUser(User user) {
        return this.orderRepository.getOrderByUser(user);
    }

    @Override
    public List<Ticket> getOrderDetailByOrder(OrderTicket ot) {
        return this.orderRepository.getOrderDetailByOrder(ot);
    }

    @Override
    public OrderTicket getOrderById(int i) {
        return this.orderRepository.getOrderById(i);
    }
    
}
