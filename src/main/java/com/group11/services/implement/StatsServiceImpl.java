/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.services.implement;

import com.group11.pojos.User;
import com.group11.repository.StatsRepository;
import com.group11.services.StatsService;
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
public class StatsServiceImpl implements StatsService{

     @Autowired
    private StatsRepository statsReposotory;
    @Override
    public List<Object[]> RouteStats() {
        return this.statsReposotory.RouteStats();
    }

    @Override
    public List<Object[]> UserStats() {
         return this.statsReposotory.UserStats();
    }

    @Override
    public List<User> listUser() {
        return this.statsReposotory.listUser();
    }

    @Override
    public List<Object[]> CountTripStats() {
       return this.statsReposotory.CountTripStats();
    }

    @Override
    public List<User> listEmplUser() {
       return this.statsReposotory.listEmplUser();
    }

    @Override
    public List<Object[]> PassStats() {
        return this.statsReposotory.PassStats();
    }
    
}
