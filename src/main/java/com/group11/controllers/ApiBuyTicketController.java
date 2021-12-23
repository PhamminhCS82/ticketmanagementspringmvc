/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.controllers;

import com.group11.services.TicketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pminh
 */
@RestController
public class ApiBuyTicketController {
    private TicketService ticketService;
    @PostMapping("/ticket")
    public void addTicket(){
        
    }
    
}
