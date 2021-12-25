package com.group11.pojos;

import com.group11.pojos.Ticket;
import com.group11.pojos.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-25T00:36:54")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, User> iduser;
    public static volatile SingularAttribute<Order, String> phone;
    public static volatile SingularAttribute<Order, Ticket> idticket;
    public static volatile SingularAttribute<Order, String> name;
    public static volatile SingularAttribute<Order, Integer> id;
    public static volatile SingularAttribute<Order, String> email;

}