package com.group11.pojos;

import com.group11.pojos.Trip;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-30T08:11:18")
=======
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-29T23:08:22")
>>>>>>> caf60ef58b986785d714010e9fd355e90da4c2b7
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, String> name;
    public static volatile SingularAttribute<Route, String> start;
    public static volatile CollectionAttribute<Route, Trip> tripCollection;
    public static volatile SingularAttribute<Route, String> finish;
    public static volatile SingularAttribute<Route, Integer> id;

}