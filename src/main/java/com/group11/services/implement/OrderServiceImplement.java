/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services.implement;

import com.group11.pojos.Tickets;
import com.group11.repository.OrderRepository;
import com.group11.services.OrderService;
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
    
}
