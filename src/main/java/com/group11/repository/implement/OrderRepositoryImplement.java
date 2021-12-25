/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository.implement;

import com.group11.pojos.OrderTicket;
import com.group11.pojos.Passengercar;
import com.group11.pojos.Ticket;
import com.group11.pojos.Tickets;
import com.group11.repository.OrderRepository;
import com.group11.repository.PassengercarRepository;
import com.group11.repository.SeatRepository;
import com.group11.repository.UserRepository;
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
    private SeatRepository seatRepository;
    @Autowired
    private PassengercarRepository passengercarRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean addOrder(int userId, Tickets tickets) {
        try {
            Session session = this.sessionFactoryBean.getObject().getCurrentSession();
            OrderTicket order = new OrderTicket();
            order.setUser(this.userRepository.getUserById(userId));
            order.setCreatedDate(new Date());
            order.setIsPaid(false);
            session.save(order);
            Passengercar car = this.passengercarRepository.getCarById(tickets.getCarId());
            Integer[] seats = tickets.getSeats();
            for (int seat: seats) {
                Ticket ticket = new Ticket();
                ticket.setIdorder(order);
                ticket.setIdseat(this.seatRepository.getSeatById(seat));
                ticket.setPassengercar(car);
                ticket.setNumber(RandomStringUtils.randomAlphanumeric(10));
                ticket.setPrice(tickets.getPrice());
                session.save(ticket);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
