/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository.implement;

import com.group11.pojos.Passengercar;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.group11.repository.PassengercarRepository;

/**
 *
 * @author pminh
 */
@Repository
@Transactional
public class PassengercarImplement implements PassengercarRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Passengercar getCarById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Passengercar.class, id);
    }


}
