/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services;

import com.group11.pojos.Comment;
import com.group11.pojos.User;
import java.util.List;

/**
 *
 * @author LocNe
 */
public interface CommentService {
      Comment addComment(String content, int postId, User user);
    long countCmt(int postId);
     List<Comment> getCmt(int kw);
}
