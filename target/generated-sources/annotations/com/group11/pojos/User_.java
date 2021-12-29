package com.group11.pojos;

import com.group11.pojos.Comment;
import com.group11.pojos.OrderTicket;
import com.group11.pojos.Passengercar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-29T23:08:22")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> firstname;
    public static volatile CollectionAttribute<User, Passengercar> passengercarCollection;
    public static volatile CollectionAttribute<User, Comment> commentCollection;
    public static volatile SingularAttribute<User, Short> active;
    public static volatile SingularAttribute<User, String> userrole;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile CollectionAttribute<User, OrderTicket> orderTicketCollection;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Integer> phone;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}