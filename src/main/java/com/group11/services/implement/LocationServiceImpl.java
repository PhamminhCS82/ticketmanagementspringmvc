/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services.implement;

import com.group11.pojos.Route;
import com.group11.pojos.Trip;

import com.group11.repository.LocationRepository;
import com.group11.services.LocationService;
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

public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Route> getRoute() {
        return this.locationRepository.getRoute("");
    }

    @Override
    public Route getRouteId(int stationId) {
        return this.locationRepository.getRouteId(stationId);
    }

    @Override
    public List<Object[]> listTour() {
        return this.locationRepository.listTour();
    }

    @Override
    public Trip getTripId(int i) {
        return this.locationRepository.getTripId(i);
    }

    @Override
    public List<Trip> getTrip(String string, int page) {
        return this.locationRepository.getTrip(string, page);
    }

    @Override
    public long countTrip() {
        return this.locationRepository.countTrip();
    }

    @Override
    public boolean addRoute(Route p) {
        return this.locationRepository.addRoute(p);
    }

    @Override
    public boolean addTrip(Trip trip) {
        return this.locationRepository.addTrip(trip);
    }

    @Override
    public boolean updateRoute(Route route) {
        return this.locationRepository.updateRoute(route);
    }

    @Override
    public boolean updateTrip(Trip trip) {
       return this.locationRepository.updateTrip(trip);
    }

    @Override
    public boolean deleteRoute(Route route) {
        return this.locationRepository.deleteRoute(route);
    }

    @Override
    public boolean deleteTrip(Trip trip) {
        return this.locationRepository.deleteTrip(trip);
    }
}
