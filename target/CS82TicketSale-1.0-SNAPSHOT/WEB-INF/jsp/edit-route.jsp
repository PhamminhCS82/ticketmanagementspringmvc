<%-- 
    Document   : edit-route
    Created on : Dec 22, 2021, 11:10:06 PM
    Author     : LocNe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">SỬA CHUYẾN</h1>
<c:url value="/edit-routes/${route.id}" var="action"/>


<section class="hero">
   
<form:form method="post" action="${action}" modelAttribute="route" enctype="multipart/form-data">
    <form:input type="hidden" id="id" path="id" value="${route.id}"/>
 
    <div class="form-group">
        <label for="name">Tên chuyến</label>
        <form:input type="text" id="name" path="name" class="form-control" value="${route.name}" disabled="disabled"/>
        <form:errors path="name" cssClass="text-danger" element="div"/>
    </div>
      <div class="form-group">
        <label for="name">Điểm đi</label>
        <form:input type="text" id="name" path="start" class="form-control" value="${route.start}"/>
        <form:errors path="start" cssClass="text-danger" element="div"/>
    </div>
      <div class="form-group">
        <label for="name">Điểm đến</label>
        <form:input type="text" id="name" path="finish" class="form-control" value="${route.finish}"/>
        <form:errors path="finish" cssClass="text-danger" element="div"/>
    </div>
    
   
   <br>
    <div class="form-group">
        <input type="submit" value="Sửa chuyến" class="btn btn-success"/>
    </div>
        
</form:form>
    
</section>
