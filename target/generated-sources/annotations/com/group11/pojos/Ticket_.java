package com.group11.pojos;

import com.group11.pojos.OrderTicket;
import com.group11.pojos.Trip;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-29T17:17:56")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, String> number;
    public static volatile SingularAttribute<Ticket, BigDecimal> price;
    public static volatile SingularAttribute<Ticket, OrderTicket> idorder;
    public static volatile SingularAttribute<Ticket, Integer> seatName;
    public static volatile SingularAttribute<Ticket, Trip> tripId;
    public static volatile SingularAttribute<Ticket, Integer> id;

}