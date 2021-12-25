package com.group11.pojos;

import com.group11.pojos.Comment;
import com.group11.pojos.Passengercar;
import com.group11.pojos.Route;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-25T16:12:20")
@StaticMetamodel(Trip.class)
public class Trip_ { 

    public static volatile SingularAttribute<Trip, Route> idroute;
    public static volatile SingularAttribute<Trip, String> price;
    public static volatile CollectionAttribute<Trip, Comment> commentCollection;
    public static volatile SingularAttribute<Trip, String> name;
    public static volatile SingularAttribute<Trip, Integer> id;
    public static volatile SingularAttribute<Trip, String> time;
    public static volatile SingularAttribute<Trip, Passengercar> passengercar;

}