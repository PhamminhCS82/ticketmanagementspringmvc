/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.pojos.Order;
import com.group11.pojos.Route;
import com.group11.pojos.Seat;
import com.group11.pojos.Ticket;
import com.group11.services.LocationService;
import com.group11.services.OrderService;
import com.group11.services.TicketService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
@ControllerAdvice
public class HomeController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private TicketService ticketService;
     @Autowired
    private OrderService orderService;

    @ModelAttribute
    public void common(Model model, HttpSession session, @RequestParam(value = "kw", required = false, defaultValue = "") String kw) {
        model.addAttribute("locations", this.locationService.getRoute());
        model.addAttribute("seats", this.ticketService.getSeat());

    }

    @GetMapping("/")
    public String index(Model model,@RequestParam(required = false) Map<String, String> params) {
         String kw = params.getOrDefault("kw", null);
         int page = Integer.parseInt(params.getOrDefault("page", "1"));
         String cateId = params.get("CateId");
        if (cateId == null) {
            model.addAttribute("routeTrip", this.locationService.getTrip(kw, page));
            model.addAttribute("counter", this.locationService.countTrip());

        } else {
            Route c =this.locationService.getRouteId(Integer.parseInt(cateId));
            model.addAttribute("products", c.getTripCollection());
        }
        return "index";
    }
//      @GetMapping("/route")
//    public String indexx(Model model,@RequestParam(required = false) Map<String, String> params) {
//        String kw = params.getOrDefault("kw", null);
//         int page = Integer.parseInt(params.getOrDefault("page", "1"));// getOrdefault neu co lay ko co de mac dinh
//        String cateId = params.get("CateId");
//        if (cateId == null) {
//            model.addAttribute("products", this.locationService.getTrip(kw, page));
//            
//
////        } else {
//////            Route c =this.locationService.getStationId(Integer.parseInt(cateId));
//////            model.addAttribute("products", c.getProductCollection());
////        }
//        return "route-trip";
//    }

    @GetMapping("/route")
    public String saleState(Model model,@RequestParam(required = false) Map<String, String> params) {
          String kw = params.getOrDefault("kw", null);
         int page = Integer.parseInt(params.getOrDefault("page", "1"));
         String cateId = params.get("CateId");
        if (cateId == null) {
            model.addAttribute("routeTrip", this.locationService.getTrip(kw, page));
            model.addAttribute("counter", this.locationService.countTrip());

        } else {
            Route c =this.locationService.getRouteId(Integer.parseInt(cateId));
            model.addAttribute("routeTrip", c.getTripCollection());
        }
        return "route-trip";
    }
    

    @GetMapping(value = "/routes/{routeId}")
    public String detail(Model model, @PathVariable(value = "routeId") int ticketId) {

        model.addAttribute("trip", locationService.getTripId(ticketId));
      
        
        return "ticket-trip";
    }
    @GetMapping(value = "/orderticket/{ticket_id}")
    public String ticket(Model model, @PathVariable(value = "ticket_id") int ticketId) {
          model.addAttribute("order", new Order());
        model.addAttribute("trip", locationService.getTripId(ticketId));
       
        
        return "orderticket";
    }
   @PostMapping("/orderticket/{ticket_id}")
    public String edit(Model model, @ModelAttribute(value = "ticket_id") @Valid Order order, BindingResult result,@PathVariable(value = "roomId") int roomId) {
        if (!result.hasErrors()) {
            this.orderService.addOrUpdate(order);
//        model.addAttribute("product",product);
            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "Có lỗi rồi!!!");
        }
        return "orderticket";
    }
    @GetMapping(value = "/ticket/{ticket_id}")
    public String editProduct(Model model, @PathVariable(value = "ticket_id") int productId) {  
            Ticket u = this.ticketService.getTicketId(productId);
            model.addAttribute("ticket", u);
            return "ticket";   
    }

    @PostMapping("/ticket/{ticket_id}")
    public String edit(Model model, @ModelAttribute(value = "product_id") @Valid Ticket ticket, BindingResult result) {
        if (!result.hasErrors()) {
            this.ticketService.addTicket(ticket);
//        model.addAttribute("product",product);
            return "redirect:/";
        } else {
            model.addAttribute("errMsg", "Có lỗi rồi!!!");
        }
        return "ticket";
    }

}
