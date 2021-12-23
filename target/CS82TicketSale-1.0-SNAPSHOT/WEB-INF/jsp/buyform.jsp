<%-- 
    Document   : buyform
    Created on : Dec 23, 2021, 9:50:11 AM
    Author     : pminh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/buyform" var="action"/>
<form:form method="post" action="${action}" modelAttribute="user">
    <div class="form-group">
        <label for="firstname">Tên</label>
        <form:input type="text" id="firstname" path="firstname" class="form-control" />
    </div>
    <div class="form-group">
        <label for="lastname">Họ</label>
        <form:input type="text" id="lastname" path="surname" class="form-control" />
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input type="email" id="email" path="email" class="form-control" />
    </div>
    <div class="form-group">
        <label for="phonenum">Số điện thoại</label>
        <form:input type="number" id="phonenum" path="phone" class="form-control" />
    </div>
    <div class="form-group">
        <input type="submit" value="Đặt vé" class="btn btn-danger" />
    </div>
</form:form>
