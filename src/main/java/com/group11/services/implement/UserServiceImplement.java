/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services.implement;

import com.group11.pojos.User;
import com.group11.repository.UserRepository;
import com.group11.services.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author pminh
 */
@Service("userDetailsService")
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(User user, String userRole) {
        if(user.getPassword() != null)
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setUserrole(userRole);
        user.setAvatar("https://res.cloudinary.com/dawairuhe/image/upload/v1640719995/defaultavatar_hst4oo.jpg");
        return this.userRepository.addUser(user, userRole);
    }

    @Override
    public List<User> getUsers(String username) {
        return this.userRepository.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Không tồn tại người dùng này");
        }
        User user = users.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserrole()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
    }

    @Override
    public boolean updateUser(User user) {
        return this.userRepository.updateUser(user);
    }

    @Override
    public User getUserId(int i) {
        return this.userRepository.getUserId(i);
    }

    @Override
    public User getUserByname(String string) {
        return userRepository.getUsers(string).get(0);
    }

    @Override
    public List<User> getRole() {
        return this.userRepository.getRole();
    }

}
