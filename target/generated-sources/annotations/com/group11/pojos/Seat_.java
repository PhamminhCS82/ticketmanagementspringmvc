package com.group11.pojos;

import com.group11.pojos.Passengercar;
import com.group11.pojos.Ticket;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-25T23:40:19")
=======
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-25T23:36:10")
>>>>>>> 9afa4bdbd56d0823bac5f6d006ac314e5d02e433
@StaticMetamodel(Seat.class)
public class Seat_ { 

    public static volatile CollectionAttribute<Seat, Ticket> ticketCollection;
    public static volatile SingularAttribute<Seat, String> name;
    public static volatile SingularAttribute<Seat, Short> emp;
    public static volatile SingularAttribute<Seat, Integer> id;
    public static volatile SingularAttribute<Seat, Passengercar> passengercar;

}