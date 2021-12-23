<%-- 
    Document   : add-route
    Created on : Dec 21, 2021, 9:51:58 PM
    Author     : LocNe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">THÊM CHUYẾN</h1>
<c:url value="/admin/add-routes" var="action"/>

<c:if test="${errMsg!=null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<section class="hero">
   
<form:form method="post" action="${action}" modelAttribute="route"
           enctype="multipart/form-data">
    <%--<form:errors path="*" cssClass="alert alert-danger" element="div"/>--%>
    <div class="form-group">
        <label for="name">Tên chuyến</label>
        <form:input type="text" id="name" path="name" class="form-control"/>
        <form:errors path="name" cssClass="text-danger" element="div"/>
    </div>
      <div class="form-group">
        <label for="name">Điểm đi</label>
        <form:input type="text" id="name" path="start" class="form-control"/>
        <form:errors path="start" cssClass="text-danger" element="div"/>
    </div>
      <div class="form-group">
        <label for="name">Điểm đến</label>
        <form:input type="text" id="name" path="finish" class="form-control"/>
        <form:errors path="finish" cssClass="text-danger" element="div"/>
    </div>
    
   
   <br>
    <div class="form-group">
        <input type="submit" value="THÊM CHUYẾN" class="btn btn-success"/>
    </div>
        
</form:form>
    
</section>
    
