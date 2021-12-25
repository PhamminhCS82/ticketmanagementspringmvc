/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services.implement;

import com.group11.pojos.Comment;
import com.group11.pojos.Trip;
import com.group11.pojos.User;
import com.group11.repository.CommentRepository;
import com.group11.repository.LocationRepository;
import com.group11.services.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LocNe
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
        @Autowired
    private LocationRepository locationRepository;

    @Override
    public Comment addComment(String comment, int trip, User creator) {
        Trip p = this.locationRepository.getTripId(trip);
               
        Comment c = new Comment();
        c.setDetail(comment);
        c.setIdtrip(p);
        c.setUser(creator);
        c.setCreateddate(new Date());
//        c.setRating(postId);
        return this.commentRepository.addComment(c);
    }

    @Override
    public long countCmt(int i) {
        return this.commentRepository.countCmt(i);
    }

    @Override
    public List<Comment> getCmt(int kw) {
          return this.commentRepository.getCmt(kw);
    }

  

}
