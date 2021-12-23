/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.pojos;

/**
 *
 * @author pminh
 */
public class TicketStats {

    /**
     * @return the tripId
     */
    public int getTripId() {
        return tripId;
    }

    /**
     * @param tripId the tripId to set
     */
    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    /**
     * @return the routeId
     */
    public int getRouteId() {
        return routeId;
    }

    /**
     * @param routeId the routeId to set
     */
    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    /**
     * @return the seatId
     */
    public int getSeatId() {
        return seatId;
    }

    /**
     * @param seatId the seatId to set
     */
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    /**
     * @return the tripName
     */
    public String getTripName() {
        return tripName;
    }

    /**
     * @param tripName the tripName to set
     */
    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    /**
     * @return the routeName
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * @param routeName the routeName to set
     */
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    /**
     * @return the carNumber
     */
    public String getCarNumber() {
        return carNumber;
    }

    /**
     * @param carNumber the carNumber to set
     */
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    /**
     * @return the seatName
     */
    public String getSeatName() {
        return seatName;
    }

    /**
     * @param seatName the seatName to set
     */
    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }
    private int tripId;
    private int routeId;
    private int seatId;
    private String tripName;
    private String routeName;
    private String carNumber;
    private String seatName;
    
    
}
