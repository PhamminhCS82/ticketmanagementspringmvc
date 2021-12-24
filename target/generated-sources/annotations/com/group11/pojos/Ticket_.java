package com.group11.pojos;

import com.group11.pojos.OrderTicket;
import com.group11.pojos.Passengercar;
import com.group11.pojos.Seat;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-24T18:46:11")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, String> number;
    public static volatile SingularAttribute<Ticket, Seat> idseat;
    public static volatile SingularAttribute<Ticket, String> price;
    public static volatile SingularAttribute<Ticket, OrderTicket> idorder;
    public static volatile SingularAttribute<Ticket, Date> usedDate;
    public static volatile SingularAttribute<Ticket, Integer> id;
    public static volatile SingularAttribute<Ticket, Passengercar> passengercar;

}