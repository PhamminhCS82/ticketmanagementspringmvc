<%-- 
    Document   : edit-profile
    Created on : Dec 24, 2021, 3:23:15 PM
    Author     : LocNe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">SỬA THÔNG TIN</h1>
<c:url value="/user/edit-users/${pageContext.request.userPrincipal.name}" var="action"/>


<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-10"><h1>Chào mừng, ${user.firstname}</h1></div>
        <div class="col-sm-2"><a href="<c:url value="/"/>" class="pull-right"></a></div>
    </div>
    <div class="row">
        <div class="col-sm-3"><!--left col-->


            <div class="text-center">
                <img src="${user.avatar}" class="avatar img-circle img-thumbnail" alt="avatar">
                <!--<h6>Upload a different photo...</h6>-->
                <!--<input type="file" class="text-center center-block file-upload">-->
            </div></hr><br>


            <div class="panel panel-default">
                <div class="panel-heading">Website <i class="fa fa-link fa-1x"></i></div>
                <div class="panel-body"><a href="http://bootnipets.com">bootnipets.com</a></div>
            </div>


            <ul class="list-group">
                <li class="list-group-item text-muted">Activity <i class="fa fa-dashboard fa-1x"></i></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Shares</strong></span> 125</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Likes</strong></span> 13</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Posts</strong></span> 37</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Followers</strong></span> 78</li>
            </ul> 
            <div class="panel panel-default">
                <div class="panel-heading">Social Media</div>
                <div class="panel-body">
                    <i class="fa fa-facebook fa-2x"></i> <i class="fa fa-github fa-2x"></i> <i class="fa fa-twitter fa-2x"></i> <i class="fa fa-pinterest fa-2x"></i> <i class="fa fa-google-plus fa-2x"></i>
                </div>
            </div>

        </div>
        <div class="col-sm-9">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <hr>
                    <form:form class="form" method="post" modelAttribute="user"  action="${action}" enctype="multipart/form-data">
                        <form:input type="hidden" id="id" path="id" value="${user.id}"/>
                        <form:input type="hidden" id="username" path="username" value="${user.username}"/>
                        <form:input type="hidden" id="userrole" path="userrole" value="${user.userrole}"/>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="first_name"><h4>First name</h4></label>
                                <form:input type="text" class="form-control" path="firstname" id="firstname" value="${user.firstname}"/>
                                <form:errors path="firstname" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="last_name"><h4>Last name</h4></label>
                                <form:input type="text" class="form-control" path="surname"  id="surname" value="${user.surname}" />
                                <form:errors path="surname" cssClass="text-danger" element="div"/>
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="phone"><h4>Phone</h4></label>
                                <form:input type="text" class="form-control" path="phone" id="phone" value="${user.phone}" />
                                <form:errors path="phone" cssClass="text-danger" />
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="email"><h4>Email</h4></label>
                                <form:input type="email" class="form-control" path="email" id="email" value="${user.email}"/>
                                <form:errors path="email" cssClass="text-danger" />
                            </div>
                        </div>

                        <div class="form-group">                      
                            <div class="col-xs-6">
                                <label for="password"><h4>Password</h4></label>
                                <form:input type="password" class="form-control" path="password" id="password" placeholder="password"/>
                                <form:errors path="password" cssClass="text-danger" />
                      <c:if test="${errMsg != null}">
                     <i class="alert alert-danger text-center">${errMsg}</i>
                 </c:if>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="image"><h4>Anh </h4></label>
                                <c:if test="${user.avatar != null}">
                                    <form:input type="hidden" id="avatar" path="file" value="${user.avatar}" class="form-control"/>
                                 
                            </c:if>
                            <c:if test="${user.avatar == null}">                        
                                <form:input type="file" id="avatar" path="file" value="${user.avatar}" class="form-control"/>
                            </c:if>  
                           
                            
                        </div>


                        
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <div class="wrapp">
                                    <button class="buttonn">Submit</button>
                                </div>
                             
                              
                            </div>
                        </div>
                    </form:form>
                    <%--</c:forEach>--%>
                    <hr>

                </div>
            </div><!--/tab-content-->

        </div><!--/col-9-->
    </div><!--/row-->
</div>
