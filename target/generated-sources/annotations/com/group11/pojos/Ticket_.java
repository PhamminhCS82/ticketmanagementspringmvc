package com.group11.pojos;

import com.group11.pojos.Seat;
import com.group11.pojos.Trip;
import com.group11.pojos.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-13T15:31:44")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, String> number;
    public static volatile SingularAttribute<Ticket, Trip> idtrip;
    public static volatile SingularAttribute<Ticket, Integer> id;
    public static volatile SingularAttribute<Ticket, Seat> idcardetail;
    public static volatile SingularAttribute<Ticket, User> user;

}