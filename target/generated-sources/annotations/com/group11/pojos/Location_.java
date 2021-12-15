package com.group11.pojos;

import com.group11.pojos.Route;
import com.group11.pojos.Station;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-13T15:31:44")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile CollectionAttribute<Location, Route> routeCollection;
    public static volatile SingularAttribute<Location, String> name;
    public static volatile CollectionAttribute<Location, Station> stationCollection;
    public static volatile SingularAttribute<Location, String> id;
    public static volatile CollectionAttribute<Location, Route> routeCollection1;

}