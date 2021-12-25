/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.Route;
import com.group11.pojos.Trip;
import com.group11.services.LocationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author LocNe
 */
@Controller
@ControllerAdvice
public class TripController {
       @Autowired
    private LocationService locationService;
       
//        @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(productValidator);
//    }

    @GetMapping("/admin/add-routes")
    public String list(Model model) {
        model.addAttribute("route", new Route());
        return "add-route";
    }
    @PostMapping("/admin/add-routes")
    public String addRoute(Model model, @ModelAttribute(value = "route")
            @Valid Route route, BindingResult result) {
        if (!result.hasErrors()) {
            if (this.locationService.addRoute(route) == true) {

                return "redirect:/"; // nếu đúng về trang chủ   
            } else {
                model.addAttribute("errMsg", "Someting wrong!!!");
            }
        }
        return "add-route"; // sai vè product
    }
     @GetMapping("/admin/add-trips")
    public String listTrip(Model model) {
        model.addAttribute("trip", new Trip());
        return "add-trip";
    }
    @PostMapping("/admin/add-trips")
    public String addTrip(Model model, @ModelAttribute(value = "trip")
            @Valid Trip trip, BindingResult result) {
        if (!result.hasErrors()) {
            if (this.locationService.addTrip(trip) == true) {

                return "redirect:/"; // nếu đúng về trang chủ   
            } else {
                model.addAttribute("errMsg", "Someting wrong!!!");
            }
        }
        return "add-trip"; // sai vè product
    }
}
