/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository.implement;

import com.group11.pojos.Order;
import com.group11.repository.OrderRepository;
import java.util.List;
import javax.persistence.Query;
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
public class OrderRepositoryImlp implements OrderRepository{

       @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public List<Order> getOrders() {
          Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Order");
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdate(Order order) {
       Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(order);
            return true;
        } catch (Exception ex) {
            System.err.println("=== ADD Order EER ===" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }
    
}
