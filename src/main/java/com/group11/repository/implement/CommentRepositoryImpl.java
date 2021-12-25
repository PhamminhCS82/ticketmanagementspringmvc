/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository.implement;

import com.group11.pojos.Comment;
import com.group11.repository.CommentRepository;
import com.group11.repository.LocationRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class CommentRepositoryImpl implements CommentRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Comment addComment(Comment c) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(c);
            return c;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public long countCmt(int i) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Comment WHERE idpost.id = :id");
        q.setParameter("id", i);
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Comment> getCmt(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Comment> query = builder.createQuery(Comment.class);
        Root root = query.from(Comment.class);
        query = query.select(root);/// cac buoc tao truyvan       
        Predicate p = builder.equal(root.get("idtrip"), locationRepository.getTripId(id).getId());
        query = query.where(p);

        query = query.orderBy(builder.desc(root.get("createddate")));
        Query q = session.createQuery(query);
        return q.getResultList();

    }
}
