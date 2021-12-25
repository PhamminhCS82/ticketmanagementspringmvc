package com.group11.pojos;

import com.group11.pojos.Trip;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-25T23:40:19")
=======
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-25T23:36:10")
>>>>>>> 9afa4bdbd56d0823bac5f6d006ac314e5d02e433
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, String> name;
    public static volatile SingularAttribute<Route, String> start;
    public static volatile CollectionAttribute<Route, Trip> tripCollection;
    public static volatile SingularAttribute<Route, String> finish;
    public static volatile SingularAttribute<Route, Integer> id;

}