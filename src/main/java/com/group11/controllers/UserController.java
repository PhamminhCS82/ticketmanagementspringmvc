/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.User;
import com.group11.services.UserService;
import freemarker.ext.beans.MapModel;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author pminh
 */
@Controller
public class UserController {
    @Autowired
    private UserService userDetailsService;
     @Autowired
    private UserService userService;
    @GetMapping("/buyform")
    public String buyFormView(Model model) {
        model.addAttribute("user", new User());
        return "buyform";
    }
    
    @PostMapping("/buyform")
    public String buyForm(Model model, @ModelAttribute(value = "user") User user) {
        if (this.userDetailsService.addUser(user) == true) {
                return "forward:/confirm";
            }
        return "buyform";
    }
    @GetMapping("/confirm")
    public String confirmView(MapModel model){
        return "buyconfirm";
    }
    @GetMapping("/signup")
    public String signupView(Model model) {
        return "signup";
    }
    @GetMapping("/signin")
    public String signinView() {
        return "signin";
    }
    @GetMapping("/user/edit-users/{user_id}")
    public String editUser(Model model, @PathVariable(value = "user_id") String user) {

        User u = this.userService.getUserByname(user);
        model.addAttribute("user", u);
        return "edit-profile";
    }

    @PostMapping("/user/edit-users/{user_id}")
    public String editUsers(Model model, @ModelAttribute(value = "user_id") @Valid User user, BindingResult result) {
        if (!result.hasErrors()) {
            this.userService.updateUser(user);

            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "Có lỗi rồi!!!");
        }
        return "edit-profile";
    }
}
