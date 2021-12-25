/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.Comment;
import com.group11.pojos.User;
import com.group11.services.CommentService;
import com.group11.services.UserService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LocNe
 */
@RestController
public class ApiCommentController {
     @Autowired
    private CommentService commentService;
     @Autowired
    private UserService userService;
//    @Autowired
//    private WebAppValidator commentValidator;
//    
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(commentValidator);
//    }


    @PostMapping(path = "/api/add-comment/", produces = {
        MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Comment> addComment( @RequestBody Map<String, String> params,HttpSession session) {
     String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User u = userService.getUserByname(username);
        if(u != null)
            try {
                String comment = params.get("detail" );
                int idpost = Integer.parseInt(params.get("idtrip"));

                Comment c = this.commentService.addComment(comment, idpost ,u);

                return new ResponseEntity<>(c, HttpStatus.CREATED);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  
        
    }
}
