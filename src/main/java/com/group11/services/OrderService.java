/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services;

import com.group11.pojos.Order;
import java.util.List;

/**
 *
 * @author LocNe
 */
public interface OrderService {
    List<Order> getOrders();
    boolean addOrUpdate(Order order);
}