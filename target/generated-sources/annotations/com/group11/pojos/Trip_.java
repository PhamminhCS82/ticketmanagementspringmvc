package com.group11.pojos;

import com.group11.pojos.Comment;
import com.group11.pojos.Passengercar;
import com.group11.pojos.Route;
import com.group11.pojos.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-23T11:47:18")
@StaticMetamodel(Trip.class)
public class Trip_ { 

    public static volatile SingularAttribute<Trip, Date> datetime;
    public static volatile SingularAttribute<Trip, Route> idroute;
    public static volatile CollectionAttribute<Trip, Ticket> ticketCollection;
    public static volatile SingularAttribute<Trip, String> price;
    public static volatile CollectionAttribute<Trip, Passengercar> passengercarCollection;
    public static volatile CollectionAttribute<Trip, Comment> commentCollection;
    public static volatile SingularAttribute<Trip, String> name;
    public static volatile SingularAttribute<Trip, Integer> id;

}