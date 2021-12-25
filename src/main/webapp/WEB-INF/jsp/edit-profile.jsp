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


<section class="hero">
 <div class="container">
        <div class="row">
            <div class="col-lg-12">

    <form:form method="post" action="${action}" modelAttribute="user" enctype="multipart/form-data">
        <form:input type="hidden" id="id" path="id" value="${user.id}"/>
        <form:input type="hidden" id="username" path="username" value="${user.username}"/>
        <form:input type="hidden" id="avatar" path="avatar" value="${user.avatar}"/>
        <form:input type="hidden"  path="userrole" id="userrole" value="${user.userrole}" />

        <div class="form-group">
            <label for="surname">Họ</label>
            <form:input type="text" id="surname" path="surname" class="form-control" value="${user.surname}" disabled="disabled"/>
            <form:errors path="surname" cssClass="text-danger" element="div"/>
        </div>
        <div class="form-group">
            <label for="firstname">Tên</label>
            <form:input type="text" id="firstname" path="firstname" class="form-control" value="${user.firstname}"/>
            <form:errors path="firstname" cssClass="text-danger" element="div"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <form:input type="email" class="form-control" path="email" id="email" value="${user.email}"/>
            <form:errors path="email" cssClass="text-danger" element="div"/>
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input type="text" class="form-control" path="phone" id="phone" value="${user.phone}" />
            <form:errors path="phone" cssClass="text-danger" element="div"/>

        </div>
                         <div class="form-group">                      
                            
                                <label for="password">Password</label>
                                <form:input type="password" class="form-control" path="password" id="password" placeholder="password" value="${user.password}"/>
                                <form:errors path="password" cssClass="text-danger" element="div" />
                    
                            </div>
<!--        <div class="form-group">
            <label>Ảnh Người dùng</label>
            <%--<form:input type="file" id="avatar" path="file" class="form-control"/>--%>
        </div>

        <img src="${user.avatar}" class="img-thumbnail"alt="Cinque Terre" style=" width: 200px;
             height: 200px;
             object-fit: cover;">-->


        <br>
        <div class="form-group">
            <input type="submit" value="Sửa thông tin" class="btn btn-success"/>
        </div>

    </form:form>
            </div></div></div>
</section>