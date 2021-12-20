/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services.implement;

import com.group11.pojos.Order;
import com.group11.repository.OrderRepository;
import com.group11.services.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LocNe
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    
      @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> getOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addOrUpdate(Order order) {
        return this.orderRepository.addOrUpdate(order);
    }
    
}
