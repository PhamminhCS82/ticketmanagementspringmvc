/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services.implement;

import com.group11.pojos.Seat;
import com.group11.repository.SeatRepository;
import com.group11.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pminh
 */
@Service
public class SeatServiceImplement implements SeatService{
    @Autowired
    private SeatRepository seatRepository;
    @Override
    public Seat getSeatById(int id) {
        return this.seatRepository.getSeatById(id);
    }
    
}
