/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services.implement;

import com.group11.pojos.Passengercar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.group11.repository.PassengercarRepository;
import com.group11.services.PassengercarService;

/**
 *
 * @author pminh
 */
@Service
@Transactional
public class PassengercarServiceImplement implements PassengercarService{

    @Autowired
    private PassengercarRepository passengerCarRepository;
    
    @Override
    public Passengercar getCarById(int id) {
        return this.passengerCarRepository.getCarById(id);
    }
    
}
