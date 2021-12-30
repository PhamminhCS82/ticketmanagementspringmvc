/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.Passengercar;
import com.group11.pojos.Route;
import com.group11.pojos.Trip;
import com.group11.pojos.User;
import com.group11.services.LocationService;
import com.group11.services.PassengercarService;
import com.group11.services.StatsService;
import com.group11.services.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private PassengercarService passengercarService;

    @RequestMapping("/admin")
    public String admin(Model model, @RequestParam(required = false) Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");

        Date fromDate = null;
        Date toDate = null;
        try{
            String f = params.getOrDefault("fromDate", null);
        if (f != null) {
            fromDate = d.parse(f);
        }

        String to = params.getOrDefault("toDate", null);
        if (to != null) {
            toDate = d.parse(to);
        }
        }catch(ParseException ex){
            ex.printStackTrace();
        }
        model.addAttribute("totalbyMonth", this.statsService.totalbyMonth(kw, fromDate, toDate));
        model.addAttribute("totalbyYear", this.statsService.totalbyYear(kw, fromDate, toDate)); 
        return "admin";
    }

    @GetMapping("/admin/trip-stats")
    public String catStats(Model model) {

        model.addAttribute("tripStats", this.statsService.RouteStats());
        model.addAttribute("routeStats", this.locationService.listTour());
        
        return "trips-state";
    }
    
    @GetMapping("/admin/pass-stats")
    public String passStats(Model model) {

        model.addAttribute("passStats", this.statsService.PassStats());
   
        return "pass-stats";
    }
      @PostMapping("/admin/pass-stats/{id}")
    public String editpass(Model model, @ModelAttribute(value = "id") @Valid Passengercar pass, BindingResult result) {
        if (!result.hasErrors()) {
            this.passengercarService.updatePass(pass);

            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "Có lỗi rồi!!!");
        }
        return "edit-pass";
    }
    @GetMapping("/admin/edit-routes/{route_id}")
    public String editRoute(Model model, @PathVariable(value = "route_id") int routeid) {

        Route u = this.locationService.getRouteId(routeid);
        model.addAttribute("route", u);
        return "edit-routes";
    }

    @PostMapping("/admin/edit-routes/{route_id}")
    public String edit(Model model, @ModelAttribute(value = "route_id") @Valid Route route, BindingResult result) {
        if (!result.hasErrors()) {
            this.locationService.updateRoute(route);

            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "Có lỗi rồi!!!");
        }
        return "edit-routes";
    }

    @GetMapping("/admin/edit-trips/{trip_id}")
    public String editTrip(Model model, @PathVariable(value = "trip_id") int trip) {

        Trip u = this.locationService.getTripId(trip);
        model.addAttribute("trip", u);
        return "edit-trips";
    }

    @PostMapping("/admin/edit-trips/{trip_id}")
    public String editTrips(Model model, @ModelAttribute(value = "trip_id") @Valid Trip trip, BindingResult result) {
        if (!result.hasErrors()) {
            this.locationService.updateTrip(trip);

            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "Có lỗi rồi!!!");
        }
        return "edit-trips";
    }

    @GetMapping("/admin/user")
    public String userStats(Model model) {

        model.addAttribute("userStats", this.statsService.listUser());
        model.addAttribute("userEmplStats", this.statsService.listEmplUser());

        return "user";
    }

    @GetMapping("/admin/edit-users/{user_id}")
    public String editUser(Model model, @PathVariable(value = "user_id") int user) {

        User u = this.userService.getUserId(user);
        model.addAttribute("user", u);
        return "edit-user";
    }

    @PostMapping("/admin/edit-users/{user_id}")
    public String editUsers(Model model, @ModelAttribute(value = "user_id") @Valid User user, BindingResult result) {
        if (!result.hasErrors()) {
            this.userService.updateUser(user);

            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "Có lỗi rồi!!!");
        }
        return "edit-user";
    }

    @GetMapping("/admin/trip-delete/{id}")
    public String TripDelete(Model model, @PathVariable(value = "id") int a) {

        Trip u = this.locationService.getTripId(a);
        this.locationService.deleteTrip(u);
//        model.addAttribute("product",product);
        return "admin";
    }

    @GetMapping("/admin/route-delete/{id}")
    public String RouteDelete(Model model, @RequestParam(required = false) Map<String, String> params) {
          String id = params.getOrDefault("id", null);
        boolean t;
         if (id != null) {
            t = this.locationService.deleteRoute(Integer.parseInt(id));
            if (t == true) {
                return "redirect:/";
            }
        }
//     
//        Route u = this.locationService.getRouteId(a);
//        this.locationService.deleteRoute(u);
//        model.addAttribute("product",product);
        return "admin";
    }
      @GetMapping("/admin/add-passs")
    public String list(Model model) {
        
        model.addAttribute("passengercar", new Passengercar());
        return "add-pass";
    }
    @GetMapping("/admin/state-trip")
    public String listStatsTrip(Model model) {
   
        model.addAttribute("counttripStats", this.statsService.CountTripStats());
        return "stats-trip";
    }
    @PostMapping("/admin/add-passs")
    public String addRoute(Model model, @ModelAttribute(value = "passengercar")
            @Valid Passengercar pass, BindingResult result) {
       
        if (!result.hasErrors()) {
            if (this.passengercarService.addPass(pass) == true) {

                return "redirect:/"; // nếu đúng về trang chủ   
            } else {
                model.addAttribute("errMsg", "Someting wrong!!!");
            }
        }
        return "add-pass"; // sai vè product
    }
    
}
