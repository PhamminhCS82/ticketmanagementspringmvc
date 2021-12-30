/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.Seats;
import com.group11.pojos.Trip;
import com.group11.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.group11.utils.Utils;
import freemarker.ext.beans.MapModel;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author pminh
 */
@Controller
public class BuyTicketController {
//    @Autowired
//    private TicketService ticketService;

    @Autowired
    private LocationService locationService;
//    @ModelAttribute
//    public void addAttributes(Model model){
//        model.addAttribute("seats", this.ticketService.getSeat());
//    }

//    @GetMapping("/buy")
//    public String getChooseSeatView(Model model) {
//        return "buyticket";
//    }
    @GetMapping("/buy")
    public String chooseSeatView(Model model, @RequestParam(value = "trip_id") Integer tripId) {
        Trip trip = locationService.getTripId(tripId);
        List<Seats> seats = Utils.countSeats(trip.getPassengercar().getNumOfSeats(), trip.getTicketCollection());
        model.addAttribute("seatofcar", seats);
        model.addAttribute("carinfo", trip.getPassengercar());
        model.addAttribute("tripinfo", trip);

        return "buyticket";
    }

    @PostMapping("/confirm")
    public String confirmView(MapModel model) {
        return "buyconfirm";
    }

}
