/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository.implement;

import com.group11.pojos.OrderTicket;
import com.group11.pojos.Ticket;
import com.group11.pojos.Tickets;
import com.group11.pojos.Trip;
import com.group11.repository.OrderRepository;
import com.group11.repository.LocationRepository;
import com.group11.repository.UserRepository;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pminh
 */
@Repository
public class OrderRepositoryImplement implements OrderRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean addOrder(Tickets tickets) {
        try {
            Session session = this.sessionFactoryBean.getObject().getCurrentSession();
            OrderTicket order = new OrderTicket();
            BigDecimal p = BigDecimal.valueOf(tickets.getSeats().length);
            BigDecimal total = tickets.getPrice().multiply(p);
            order.setUser(this.userRepository.getUserById(tickets.getUserId()));
            order.setCreatedDate(new Date());
            order.setIsPaid(false);
            order.setTotalPrice(total);
            session.save(order);
            Trip trip = locationRepository.getTripId(tickets.getTripId());
            Integer[] seats = tickets.getSeats();
            for (int seat: seats) {
                Ticket ticket = new Ticket();
                ticket.setIdorder(order);
                ticket.setSeatName(seat);
                ticket.setTripId(trip);
                ticket.setNumber(RandomStringUtils.randomAlphanumeric(10));
                ticket.setPrice(tickets.getPrice());
                session.save(ticket);
            }
            trip.setNumOfSeats(trip.getNumOfSeats() - tickets.getSeats().length);
            locationRepository.updateTrip(trip);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean addOnlineOrder(Tickets tickets, BigDecimal amount, String onlinePayId) {
        try {
            Session session = this.sessionFactoryBean.getObject().getCurrentSession();
            OrderTicket order = new OrderTicket();
            order.setUser(this.userRepository.getUserById(tickets.getUserId()));
            order.setCreatedDate(new Date());
            order.setIsPaid(true);
            order.setOnlinePay(onlinePayId);
            order.setTotalPrice(amount);
            session.save(order);
            Trip trip = locationRepository.getTripId(tickets.getTripId());
            Integer[] seats = tickets.getSeats();
            for (int seat: seats) {
                Ticket ticket = new Ticket();
                ticket.setIdorder(order);
                ticket.setSeatName(seat);
                ticket.setTripId(trip);
                ticket.setNumber(RandomStringUtils.randomAlphanumeric(10));
                ticket.setPrice(tickets.getPrice());
                session.save(ticket);
            }
            trip.setNumOfSeats(trip.getNumOfSeats() - tickets.getSeats().length);
            locationRepository.updateTrip(trip);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
