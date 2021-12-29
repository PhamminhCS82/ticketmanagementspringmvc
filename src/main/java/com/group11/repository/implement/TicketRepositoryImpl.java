/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository.implement;

import com.group11.pojos.Ticket;
import com.group11.repository.TicketRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LocNe
 */
@Repository
@Transactional
public class TicketRepositoryImpl implements TicketRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addTicket(Ticket p) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {

            session.save(p);

            return true;
        } catch (Exception ex) {
            System.err.println("=== ADD TICKET ERRER ===" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public Ticket getTicketId(int i) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Ticket.class, i);
    }

}
