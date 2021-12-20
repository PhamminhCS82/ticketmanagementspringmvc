/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository;

import com.group11.pojos.Seat;
import com.group11.pojos.Ticket;
import java.util.List;

/**
 *
 * @author LocNe
 */
public interface TicketRepository {
    boolean addTicket(Ticket p);
     List<Seat> getSeat();
    Seat getSeatId(int id);
     Ticket getTicketId(int id);
     
}
