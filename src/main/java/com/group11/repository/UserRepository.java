/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository;

import com.group11.pojos.User;
import java.util.List;
/**
 *
 * @author pminh
 */
public interface UserRepository {
    boolean addUser(User user);
    boolean updateUser(User user);
    List<User> getUsers(String username);

    User getUserId(int id);
    User getUserByname(String id);
    List<User> getRole();
    
    User getUserById(int id);

}
