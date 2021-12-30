/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.Trip;
import com.group11.pojos.User;
import com.group11.services.UserService;
import javax.servlet.http.HttpSession;

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

    @GetMapping("/buyform")
    public String buyFormView(Model model, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if (u != null) {
            return "index";
        }
        model.addAttribute("user", new User());
        return "buyform";
    }

    @PostMapping("/buyform")
    public String buyForm(Model model, @ModelAttribute(value = "user") User user, HttpSession session) {
        Trip trip = (Trip) session.getAttribute("choosedTrip");
        if (this.userDetailsService.addUser(user, User.Roles.GUEST.toString()) == true && trip != null) {
            session.setAttribute("user", model.getAttribute("user"));
            return String.format("redirect:/buy?trip_id=%d", trip.getId());
        }
        return "buyform";
    }

    @GetMapping("/signup")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupView(Model model, @ModelAttribute(value = "user") User user) {
        if (user.getPassword().isEmpty()
                || !user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("errMsg", "Mat khau KHONG khop!!!");
        } else {
            if (this.userDetailsService.addUser(user, User.Roles.USER.toString()) == true) {
                return "redirect:/signin";
            }

            model.addAttribute("errMsg", "Co loi xay ra, vui long quay lai sau!!!");
        }

        return "signup";
    }

    @GetMapping("/admin/add-drivers")
    public String adminriver(Model model) {
        model.addAttribute("user", new User());
        return "add-driver";
    }

    @PostMapping("/admin/add-drivers")
    public String addriver(Model model, @ModelAttribute(value = "user") User user) {
        if (user.getPassword().isEmpty()
                || !user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("errMsg", "Mat khau KHONG khop!!!");
        } else {
            if (this.userDetailsService.addUser(user, User.Roles.DRIVER.toString()) == true) {
                return "redirect:/admin";
            }

            model.addAttribute("errMsg", "Co loi xay ra, vui long quay lai sau!!!");
        }

        return "add-driver";
    }

    @GetMapping("/admin/add-employs")
    public String adminemploy(Model model) {
        model.addAttribute("user", new User());
        return "add-employ";
    }

    @PostMapping("/admin/add-employs")
    public String addploy(Model model, @ModelAttribute(value = "user") User user) {
        if (user.getPassword().isEmpty()
                || !user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("errMsg", "Mat khau KHONG khop!!!");
        } else {
            if (this.userDetailsService.addUser(user, User.Roles.EMPLOYEE.toString()) == true) {
                return "redirect:/admin";
            }

            model.addAttribute("errMsg", "Co loi xay ra, vui long quay lai sau!!!");
        }

        return "add-employ";
    }

    @GetMapping("/signin")
    public String signinView() {
        return "signin";
    }

    @GetMapping("/user/edit-users/{user_id}")
    public String editUser(Model model, @PathVariable(value = "user_id") String user) {

        User u = this.userDetailsService.getUserByname(user);
        model.addAttribute("user", u);
        return "edit-profile";
    }

    @PostMapping("/user/edit-users/{user_id}")
    public String editUsers(Model model, @ModelAttribute(value = "user_id") @Valid User user, BindingResult result) {
        if (!result.hasErrors()) {
            this.userDetailsService.updateUser(user);

            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "Có lỗi rồi!!!");
        }
        return "edit-profile";
    }
}
