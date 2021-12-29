/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository.implement;

import com.group11.pojos.Route;
import com.group11.pojos.User;
import com.group11.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pminh
 */
@Repository
@Transactional
public class UserRepositoryImplement implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public boolean addUser(User user, String userRole) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {
            session.save(user);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);

        if (!username.isEmpty()) {
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query.where(p);
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean updateUser(User user) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        try {

            session.update(user);

            return true;
        } catch (Exception ex) {
            System.err.println("=== ADD TICKET ERRER ===" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public User getUserId(int i) {
        Session s = sessionFactoryBean.getObject().getCurrentSession();
        return s.get(User.class, i);
    }

    @Override
    public User getUserByname(String id) {
        Session s = this.sessionFactoryBean.getObject().getCurrentSession();
        return s.get(User.class, id);
    }

    @Override
    public List<User> getRole() {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);

        Predicate p = builder.equal(root.get("userrole").as(String.class), "DRIVER");
        query.where(p);

        Query q = session.createQuery(query);
        return q.getResultList();

   

}
     @Override
    public User getUserById(int id) {
        Session session = this.sessionFactoryBean.getObject().getCurrentSession();
        return session.get(User.class, id);

    }}
