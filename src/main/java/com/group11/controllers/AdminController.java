/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.Route;
import com.group11.pojos.Trip;
import com.group11.pojos.User;
import com.group11.services.LocationService;
import com.group11.services.StatsService;
import com.group11.services.UserService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author pminh
 */
@Controller
public class AdminController {

    @Autowired
    private StatsService statsService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private UserService userService;

    @RequestMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/trip-stats")
    public String catStats(Model model) {

        model.addAttribute("tripStats", this.statsService.RouteStats());
        model.addAttribute("routeStats", this.locationService.listTour());
        return "trips-state";
    }

    @GetMapping("/edit-routes/{route_id}")
    public String editRoute(Model model, @PathVariable(value = "route_id") int routeid) {

        Route u = this.locationService.getRouteId(routeid);
        model.addAttribute("route", u);
        return "edit-routes";
    }

    @PostMapping("/edit-routes/{route_id}")
    public String edit(Model model, @ModelAttribute(value = "route_id") @Valid Route route, BindingResult result) {
        if (!result.hasErrors()) {
            this.locationService.updateRoute(route);

            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "Có lỗi rồi!!!");
        }
        return "edit-routes";
    }

    @GetMapping("/edit-trips/{trip_id}")
    public String editTrip(Model model, @PathVariable(value = "trip_id") int trip) {

        Trip u = this.locationService.getTripId(trip);
        model.addAttribute("trip", u);
        return "edit-trips";
    }

    @PostMapping("/edit-trips/{trip_id}")
    public String editTrips(Model model, @ModelAttribute(value = "trip_id") @Valid Trip trip, BindingResult result) {
        if (!result.hasErrors()) {
            this.locationService.updateTrip(trip);

            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "Có lỗi rồi!!!");
        }
        return "edit-trips";
    }
//    @GetMapping("/trip/remove/{product_id}")
//    public String delete(Model model, @PathVariable(value = "product_id") int a) {
//       
//            Route u = this.locationService.getRouteId(a);
//            this.locationService.addRoute(u);
////        model.addAttribute("product",product);
//            return "redirect:/";
//  
// 
//    }
    @GetMapping("/user")
    public String userStats(Model model) {

        model.addAttribute("userStats", this.statsService.listUser());

        return "user";
    }

    @GetMapping("/edit-users/{user_id}")
    public String editUser(Model model, @PathVariable(value = "user_id") int user) {

        User u = this.userService.getUserId(user);
        model.addAttribute("user", u);
        return "edit-user";
    }

    @PostMapping("/edit-users/{user_id}")
    public String editUsers(Model model, @ModelAttribute(value = "user_id") @Valid User user, BindingResult result) {
        if (!result.hasErrors()) {
            this.userService.updateUser(user);

            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "Có lỗi rồi!!!");
        }
        return "edit-user";
    }
    @GetMapping("/trip-delete/{id}")
    public String TripDelete(Model model, @PathVariable(value = "id") int a) {

            Trip u = this.locationService.getTripId(a);
            this.locationService.deleteTrip(u);
//        model.addAttribute("product",product);
            return "admin";
    }
       @GetMapping("/route-delete/{id}")
    public String RouteDelete(Model model, @PathVariable(value = "id") int a) {

            Route u = this.locationService.getRouteId(a);
            this.locationService.deleteRoute(u);
//        model.addAttribute("product",product);
            return "admin";
    }
}
