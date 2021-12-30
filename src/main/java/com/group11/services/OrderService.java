/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services;

import com.group11.pojos.Tickets;
import java.math.BigDecimal;

/**
 *
 * @author pminh
 */
public interface OrderService {
    boolean addOrder(Tickets ticket);
    boolean addOnlineOrder(Tickets tickets, BigDecimal amount, String onlinePayId);
}
