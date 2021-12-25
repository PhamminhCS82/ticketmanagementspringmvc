/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.Passengercar;
import com.group11.services.TicketService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import com.group11.services.PassengercarService;
import freemarker.ext.beans.MapModel;

/**
 *
 * @author pminh
 */
@Controller
public class BuyTicketController {
//    @Autowired
//    private TicketService ticketService;
    @Autowired
    private PassengercarService passengerCarService;
//    @ModelAttribute
//    public void addAttributes(Model model){
//        model.addAttribute("seats", this.ticketService.getSeat());
//    }
    @GetMapping("/buy")
    public String chooseSeatView(Model model, @RequestParam(value="car_id") Integer carId) {
        Passengercar car = this.passengerCarService.getCarById(carId);
        model.addAttribute("seatofcar", car.getSeatCollection());
        model.addAttribute("carinfo", car);
        model.addAttribute("tripinfo", car.getIdTrip());
        System.out.println(car.getIdTrip().getName());
        return "buyticket";
    }
    
}
