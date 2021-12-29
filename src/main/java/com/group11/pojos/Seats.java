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
public class Seats implements Comparable<Seats>{
    private Integer name;
    private boolean blank;

    /**
     * @return the name
     */
    public Integer getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(Integer name) {
        this.name = name;
    }

    /**
     * @return the blank
     */
    public boolean isBlank() {
        return blank;
    }

    /**
     * @param blank the blank to set
     */
    public void setBlank(boolean blank) {
        this.blank = blank;
    }

    @Override
    public int compareTo(Seats seat) {
        if (this.name > seat.getName()) {
 
            // if current object is greater,then return 1
            return 1;
        }
        else if (this.name < seat.getName()) {
 
            // if current object is greater,then return -1
            return -1;
        }
        else {
 
            // if current object is equal to o,then return 0
            return 0;
        }
    }



    
}
