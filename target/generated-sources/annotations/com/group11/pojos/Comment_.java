package com.group11.pojos;

import com.group11.pojos.Trip;
import com.group11.pojos.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-30T08:11:18")
=======
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-29T23:08:22")
>>>>>>> caf60ef58b986785d714010e9fd355e90da4c2b7
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Trip> idtrip;
    public static volatile SingularAttribute<Comment, Date> createddate;
    public static volatile SingularAttribute<Comment, Integer> rating;
    public static volatile SingularAttribute<Comment, Integer> id;
    public static volatile SingularAttribute<Comment, String> detail;
    public static volatile SingularAttribute<Comment, User> user;

}