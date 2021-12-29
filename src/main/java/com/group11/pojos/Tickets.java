/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.pojos;

import java.math.BigDecimal;

/**
 *
 * @author pminh
 */
public class Tickets {

    private int userId;
    private Integer[] seats;
    private int tripId;
    private BigDecimal price;

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the seats
     */
    public Integer[] getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(Integer[] seats) {
        this.seats = seats;
    }

    /**
     * @return the tripId
     */
    public int getTripId() {
        return tripId;
    }

    /**
     * @param tripId the carId to set
     */
    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
