package com.group11.pojos;

import com.group11.pojos.Seat;
import com.group11.pojos.Ticket;
import com.group11.pojos.Trip;
import com.group11.pojos.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-24T18:46:11")
@StaticMetamodel(Passengercar.class)
public class Passengercar_ { 

    public static volatile CollectionAttribute<Passengercar, Ticket> ticketCollection;
    public static volatile SingularAttribute<Passengercar, Trip> idtrip;
    public static volatile SingularAttribute<Passengercar, String> carnumber;
    public static volatile SingularAttribute<Passengercar, String> name;
    public static volatile CollectionAttribute<Passengercar, Seat> seatCollection;
    public static volatile SingularAttribute<Passengercar, Short> active;
    public static volatile SingularAttribute<Passengercar, Integer> id;
    public static volatile SingularAttribute<Passengercar, User> user;

}