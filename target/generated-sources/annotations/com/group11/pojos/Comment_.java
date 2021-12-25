package com.group11.pojos;

import com.group11.pojos.Trip;
import com.group11.pojos.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-25T23:40:19")
=======
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-25T23:36:10")
>>>>>>> 9afa4bdbd56d0823bac5f6d006ac314e5d02e433
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Trip> idtrip;
    public static volatile SingularAttribute<Comment, Date> createddate;
    public static volatile SingularAttribute<Comment, Integer> rating;
    public static volatile SingularAttribute<Comment, Integer> id;
    public static volatile SingularAttribute<Comment, String> detail;
    public static volatile SingularAttribute<Comment, User> user;

}