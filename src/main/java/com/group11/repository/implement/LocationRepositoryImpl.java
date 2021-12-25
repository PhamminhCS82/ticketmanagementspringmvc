/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository.implement;

import com.group11.pojos.Route;
import com.group11.pojos.Ticket;

import com.group11.pojos.Trip;
import com.group11.repository.LocationRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LocNe
 */
@Repository
@Transactional
public class LocationRepositoryImpl implements LocationRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Route> getRoute(String kw) {

        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Route");
        return q.getResultList();
    }

    @Override
    public Route getRouteId(int stationId) {

        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Route.class, stationId);
    }

    @Override
    public List<Object[]> listTour() {
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

        query.multiselect(rootT.get("id"), rootT.get("name"), rootT.get("price"), rootT.get("datetime"), rootT.get("time"), rootT.get("name"));
        query.where(predicates.toArray(new Predicate[]{}));

        org.hibernate.query.Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public Trip getTripId(int i) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Trip.class, i);
    }

    @Override
    public List<Trip> getTrip(String kw, int page) {

        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery(Trip.class);
        Root root = query.from(Trip.class);
        query = query.select(root);/// cac buoc tao truyvan

        if (kw != null) {

            Predicate p = builder.like(root.get("name").as(String.class),
                    String.format("%%%s%%", kw));
            query = query.where(p);
        }
        query = query.orderBy(builder.desc(root.get("id")));
        Query q = session.createQuery(query);
        int max = 8;
        q.setMaxResults(max);//moi 1 lan lay 6 phan tu
        q.setFirstResult((page - 1) * max);// vi tri bat dau lay vd trang (1-1)*6 tức là lấy từ vị trí 0,còn (2-1)*6 tức là lấy từ vị trí thứ 6
        return q.getResultList();
    }

    @Override
    public long countTrip() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("select count(*) from Trip");
        return Long.parseLong(q.getSingleResult().toString());//
    }

    @Override
    public boolean addRoute(Route p) {
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
    public boolean addTrip(Trip trip) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {

            session.save(trip);

            return true;
        } catch (Exception ex) {
            System.err.println("=== ADD TICKET ERRER ===" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateRoute(Route route) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {

            session.update(route);

            return true;
        } catch (Exception ex) {
            System.err.println("=== ADD TICKET ERRER ===" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateTrip(Trip trip) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {

            session.update(trip);

            return true;
        } catch (Exception ex) {
            System.err.println("=== ADD TICKET ERRER ===" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }


    @Override
    public boolean deleteRoute(Route route) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
           
            session.delete(route);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    @Override
    public boolean deleteTrip(Trip trip) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
           
            session.delete(trip);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    @Override
    public List<Trip> getTripName(String string) {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Trip");
        return q.getResultList();
    }

}
