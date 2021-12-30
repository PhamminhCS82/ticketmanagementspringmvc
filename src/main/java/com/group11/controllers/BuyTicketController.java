/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.Seats;
import com.group11.pojos.Tickets;
import com.group11.pojos.Trip;
import com.group11.services.LocationService;
import com.group11.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.group11.utils.Utils;
import freemarker.ext.beans.MapModel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private OrderService orderService;
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
    
    @GetMapping("/api/order-payment")
    public String getOnlineOrder(Model model, @RequestParam(required = false) Map<String, String> params, HttpSession session) {
        Tickets ticket = (Tickets) session.getAttribute("orderTicket");
        String amount = params.get("amount");
        String onlineOrderId = params.get("apptransid");
        String status = params.get("status");
        if (status != null && Integer.valueOf(status) == 1) {
            if (this.orderService.addOnlineOrder(ticket, BigDecimal.valueOf(Double.valueOf(amount)), onlineOrderId)) {
                model.addAttribute("totalPrice", amount);
                model.addAttribute("orderResult", "Thành công");
                model.addAttribute("onlineId", onlineOrderId);
                model.addAttribute("orderDetail", ticket);
                return "order-detail";
            }
            return "not-found";
        }
        return "order-detail";
    }
}
