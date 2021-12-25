/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.User;
import com.group11.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author pminh
 */
@Controller
public class UserController {

    @Autowired
    private UserService userDetailsService;

    @GetMapping("/buyform")
    public String buyFormView(Model model) {
        model.addAttribute("user", new User());
        return "buyform";
    }

    @PostMapping("/buyform")
    public String buyForm(Model model, @ModelAttribute(value = "user") User user) {
        if (this.userDetailsService.addUser(user) == true) {
            return String.format("forward:/buy?car_id=%d", 1);
        }
        return "buyform";
    }

    @GetMapping("/signup")
    public String signupView(Model model) {
        return "signup";
    }

    @GetMapping("/signin")
    public String signinView() {
        return "signin";
    }
}
