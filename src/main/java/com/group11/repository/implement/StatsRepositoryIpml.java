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
import com.group11.pojos.Passengercar;
import com.group11.repository.StatsRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
public class StatsRepositoryIpml implements StatsRepository {

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

        query.multiselect(rootU.get("id"), rootU.get("username"), rootU.get("password"), rootU.get("surname"), rootU.get("firstname"), rootU.get("email"), rootU.get("phone"),
                 rootU.get("userrole"));
        query.where(predicates.toArray(new Predicate[]{}));

        org.hibernate.query.Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public List<User> listUser() {
        Session session = this.sessionFactory.getObject().getCurrentSession();


        Query q = session.createQuery("SELECT u FROM User u WHERE u.userrole = :userrole");
        q.setParameter("userrole", "DRIVER");
        return q.getResultList();   

    }

    @Override
    public List<Object[]> CountTripStats() {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        Root rootT = query.from(Trip.class);
        Root rootR = query.from(Route.class);
        query.where(builder.equal(rootT.get("idroute"), rootR.get("id")));
        query.multiselect( rootR.get("id"),rootR.get("name"), builder.count(rootT.get("id")));
        
        query.groupBy(rootR.get("id"));
        
        Query q= session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public List<User> listEmplUser() {
         Session session = this.sessionFactory.getObject().getCurrentSession();


        Query q = session.createQuery("SELECT u FROM User u WHERE u.userrole = :userrole");
        q.setParameter("userrole", "EMPLOYEE");
        return q.getResultList();   

    }

    @Override
    public List<Object[]> PassStats() {
          Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        Root rootP = query.from(Passengercar.class);
        Root rootU = query.from(User.class);
        Root rootT = query.from(Trip.class);
         List<Predicate> predicates = new ArrayList<>();
         
        predicates.add(builder.equal(rootP.get("user"), rootU.get("id")));
        predicates.add(builder.equal(rootP.get("idtrip"), rootT.get("id")));
//        predicates.add(builder.equal(rootU.get("firstname"),rootP.get("user")));
        
        query.multiselect( rootP.get("id"),rootU.get("firstname"),rootT.get("name"),rootT.get("datetime"),rootT.get("time"),rootP.get("carnumber"));
         query.where(predicates.toArray(new Predicate[]{}));
//          Predicate p = builder.equal(rootU.get("firstname"),rootP.get("user"));
//            query = query.where(p);
//        query.groupBy(rootT.get("id"));
//        query.groupBy(rootU.get("id"));
        
        org.hibernate.query.Query q = session.createQuery(query);

        return q.getResultList();
    }

}
