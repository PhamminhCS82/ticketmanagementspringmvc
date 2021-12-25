package com.group11.pojos;

import com.group11.pojos.ActivateTrip;
import com.group11.pojos.Route;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-25T19:17:16")
@StaticMetamodel(Trip.class)
public class Trip_ { 

    public static volatile SingularAttribute<Trip, Route> idroute;
    public static volatile SingularAttribute<Trip, String> price;
    public static volatile CollectionAttribute<Trip, ActivateTrip> activateTripCollection;
    public static volatile SingularAttribute<Trip, String> name;
    public static volatile SingularAttribute<Trip, Integer> id;
    public static volatile SingularAttribute<Trip, String> time;

}