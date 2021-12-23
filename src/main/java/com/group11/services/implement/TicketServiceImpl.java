/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services.implement;

import com.group11.pojos.Seat;
import com.group11.pojos.Ticket;
import com.group11.repository.TicketRepository;
import com.group11.services.TicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LocNe
 */
@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public boolean addTicket(Ticket p) {
        return this.ticketRepository.addTicket(p);
    }

    @Override
    public List<Seat> getSeat() {
        return ticketRepository.getSeat();
    }

    @Override
    public Seat getSeatId(int i) {
        return ticketRepository.getSeatId(i);
    }

    @Override
    public Ticket getTicketId(int i) {
        return ticketRepository.getTicketId(i);
    }

    @Override
    public List<Seat> getSeat(int i) {
        return ticketRepository.getSeat(i);
    }

}
