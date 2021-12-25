/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services;

import com.group11.pojos.Passengercar;

/**
 *
 * @author pminh
 */
public interface PassengercarService {
    Passengercar getCarById(int id);
     boolean updatePass(Passengercar p);
     boolean addPass(Passengercar p);
}
