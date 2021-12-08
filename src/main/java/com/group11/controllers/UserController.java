/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author pminh
 */
@Controller
public class UserController {
    @GetMapping("/signup")
    public String signupView(Model model) {
        return "signup";
    }
    @GetMapping("/signin")
    public String signinView() {
        return "signin";
    }
}
