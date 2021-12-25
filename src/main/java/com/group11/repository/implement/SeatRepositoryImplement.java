/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository.implement;

import com.group11.pojos.Seat;
import com.group11.repository.SeatRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pminh
 */
@Transactional
@Repository
public class SeatRepositoryImplement implements SeatRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Seat getSeatById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Seat.class, id);
    }

}
