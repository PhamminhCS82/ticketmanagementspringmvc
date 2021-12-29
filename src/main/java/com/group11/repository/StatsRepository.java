/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository;

import com.group11.pojos.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LocNe
 */
public interface StatsRepository {
    List<Object[]> RouteStats();
     List<Object[]> UserStats();
     List<User> listUser( );
     List<User> listEmplUser( );
     List<Object[]> CountTripStats();
     List<Object[]> PassStats();
     
     List<Object[]> totalbyMonth(String kw, Date fromDate, Date toDate);
      List<Object[]> totalbyYear(String kw, Date fromDate, Date toDate);
     
}
