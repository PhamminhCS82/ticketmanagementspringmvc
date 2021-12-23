/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository.implement;

import com.group11.pojos.Route;
import com.group11.pojos.Ticket;
import com.group11.pojos.Trip;
import com.group11.pojos.User;
import com.group11.repository.StatsRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class StatsRepositoryIpml implements StatsRepository{
   @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> RouteStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rootR = query.from(Route.class);
        Root rootT = query.from(Trip.class);
        Root rootTicket = query.from(Ticket.class);

//        String username = SecurityContextHolder.getContext().getAuthentication().getName();    
//         User user = userRepository.getUserByUsername(username);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootR.get("id"), rootT.get("idroute")));
//        predicates.add(builder.equal(rootT.get("id"), rootTicket.get("idticket")));

        query.multiselect(rootR.get("id"), rootR.get("name"), rootR.get("start"), rootR.get("finish"));
        query.where(predicates.toArray(new Predicate[]{}));
       query.groupBy(rootR.get("id"));
        org.hibernate.query.Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public List<Object[]> UserStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rootU = query.from(User.class);
        

//        String username = SecurityContextHolder.getContext().getAuthentication().getName();    
//         User user = userRepository.getUserByUsername(username);
        List<Predicate> predicates = new ArrayList<>();
//        predicates.add(builder.equal(rootR.get("id"), rootT.get("idroute")));
//        predicates.add(builder.equal(rootT.get("id"), rootTicket.get("idticket")));

        query.multiselect(rootU.get("id"), rootU.get("username"), rootU.get("password"), rootU.get("surname"), rootU.get("firstname"), rootU.get("email"), rootU.get("phone")
        , rootU.get("userrole"));
        query.where(predicates.toArray(new Predicate[]{}));
       
        org.hibernate.query.Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public List<User> listUser() {
           Session session = this.sessionFactory.getObject().getCurrentSession();
        String query = " FROM User u WHERE u.userrole = :DRIVER" ;


        List<User> products = session.createQuery(query).getResultList();
        return products;
        
    }
    
}
