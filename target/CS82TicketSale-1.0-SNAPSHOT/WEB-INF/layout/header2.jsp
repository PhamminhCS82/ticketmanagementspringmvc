<%-- 
    Document   : header2
    Created on : Dec 21, 2021, 8:59:52 PM
    Author     : pminh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="topnav" id="myTopnav">
    <a href="<c:url value="/"/>" class="active">Trang chủ</a>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
    <a href="<c:url value="/signin"/>">Đăng nhập</a>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="<c:url value="/" />">${pageContext.request.userPrincipal.name}</a>
        <a href="<c:url value="/logout" />">Đăng xuất</a>
        </c:if>
    
    
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
        <i class="fa fa-bars"></i>
    </a>
</div>
