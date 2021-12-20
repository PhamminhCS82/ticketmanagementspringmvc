/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository;


import com.group11.pojos.Route;
import com.group11.pojos.Trip;

import java.util.List;

/**
 *
 * @author LocNe
 */
public interface LocationRepository {
    List<Route> getRoute(String kw);
    List<Trip> getTrip(String kw,int page);
    Route getRouteId(int routeId);
    List<Object[]> listTour();
    Trip getTripId(int id);
     long countTrip();
    
}
