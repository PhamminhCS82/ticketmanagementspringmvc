package com.group11.pojos;

import com.group11.pojos.Trip;
import com.group11.pojos.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-29T23:08:22")
@StaticMetamodel(Passengercar.class)
public class Passengercar_ { 

    public static volatile SingularAttribute<Passengercar, Integer> numOfSeats;
    public static volatile SingularAttribute<Passengercar, String> carnumber;
    public static volatile SingularAttribute<Passengercar, String> name;
    public static volatile SingularAttribute<Passengercar, Short> active;
    public static volatile CollectionAttribute<Passengercar, Trip> tripCollection;
    public static volatile SingularAttribute<Passengercar, Integer> id;
    public static volatile SingularAttribute<Passengercar, User> user;

}