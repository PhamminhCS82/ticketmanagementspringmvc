package com.group11.pojos;

import com.group11.pojos.Ticket;
import com.group11.pojos.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-29T23:08:22")
@StaticMetamodel(OrderTicket.class)
public class OrderTicket_ { 

    public static volatile SingularAttribute<OrderTicket, Boolean> isPaid;
    public static volatile SingularAttribute<OrderTicket, Date> createdDate;
    public static volatile CollectionAttribute<OrderTicket, Ticket> ticketCollection;
    public static volatile SingularAttribute<OrderTicket, Integer> id;
    public static volatile SingularAttribute<OrderTicket, User> user;

}