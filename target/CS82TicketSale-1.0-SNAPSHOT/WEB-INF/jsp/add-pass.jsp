<%-- 
    Document   : add-pass
    Created on : Dec 24, 2021, 11:16:42 PM
    Author     : LocNe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">THÊM CHUYẾN</h1>
<c:url value="/admin/add-passs" var="action"/>

<c:if test="${errMsg!=null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<section class="hero">

    <form:form method="post" action="${action}" modelAttribute="passengercar"
               enctype="multipart/form-data">
        <%--<form:errors path="*" cssClass="alert alert-danger" element="div"/>--%>
        <div class="form-group">
            <label for="name">Tên xe</label>
            <form:input type="text" id="carnumber" path="carnumber" class="form-control"/>
            <form:errors path="carnumber" cssClass="text-danger" element="div"/>
        </div>
    
                <div class="form-group">
        <label for="cate">Tài xế</label>
        <form:select id="cate" path="user" class="form-control">
            <c:forEach items="${getDriver}" var="cat">
                <option value="${cat.id}">${cat.firstname}</option>
            </c:forEach>
        </form:select>
                <label for="cate">Chuyến</label>
        <form:select id="cate" path="idtrip" class="form-control">
            <c:forEach items="${getTripName}" var="cat">
                <option value="${cat.id}">${cat.name}</option>
            </c:forEach>
        </form:select>
        <%--<form:input type="text" id="cate" path="category" cssClass="form-control"/>--%>
        
  


        <br>
        <div class="form-group">
            <input type="submit" value="THÊM CHUYẾN CHO TÀI XẾ" class="btn btn-success"/>
        </div>

    </form:form>

</section>