<%-- 
    Document   : order-ticket
    Created on : Dec 20, 2021, 9:22:00 PM
    Author     : LocNe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<c:url value="/user/add-products" var="action"/>

<c:if test="${errMsg!=null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<section class="hero">
   
<form:form method="post" action="${action}" modelAttribute="product"
           enctype="multipart/form-data">
    <%--<form:errors path="*" cssClass="alert alert-danger" element="div"/>--%>
    <div class="form-group">
        <label for="name">Tên sản phẩm</label>
        <form:input type="text" id="name" path="name" class="form-control"/>
        <form:errors path="name" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="price">Giá</label>
        <form:input type="text" id="price" path="price" class="form-control"/>
        <form:errors path="price" cssClass="text-danger" element="div"/>
    </div>
    
     <div class="form-group">
        <label for="cate">Loại sản phẩm</label>
        <form:select id="cate" path="category" class="form-control">
            <c:forEach items="${categories}" var="cat">
                <option value="${cat.id}">${cat.name}</option>
            </c:forEach>
        </form:select>
        <%--<form:input type="text" id="cate" path="category" cssClass="form-control"/>--%>
        
    </div>

        <div class="form-group">
            <label for="description">Mô tả</label>
            <form:textarea type="text" id="description" path="description" class="form-control"></form:textarea>
             <form:errors path="description" cssClass="text-danger" element="div"/>
        </div>
            <div class="form-group">
                <label for="factory">Xuất xứ</label>
            <form:input type="text" id="factory" path="factory" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="milliliter">Khối lượng/ dung tích</label>
            <form:input type="text" id="milliliter" path="milliliter" class="form-control"/>
              <form:errors path="milliliter" cssClass="text-danger" element="div"/>
        </div>
        <div class="form-group">
            <label>Ảnh sản phẩm</label>
            <form:input type="file" id="image" path="file" class="form-control"/>
            <form:errors path="file" cssClass="text-danger" element="div"/>
        </div>
   <br>
    <div class="form-group">
        <input type="submit" value="THÊM SẢN PHẨM" class="btn btn-success"/>
    </div>
        
</form:form>
    
</section>
    