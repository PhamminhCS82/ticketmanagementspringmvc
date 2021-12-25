<%-- 
    Document   : add-trip
    Created on : Dec 21, 2021, 10:35:41 PM
    Author     : LocNe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">THÊM CHUYẾN</h1>
<c:url value="/admin/add-trips" var="action"/>

<c:if test="${errMsg!=null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<section class="hero">

    <form:form method="post" action="${action}" modelAttribute="trip"
               enctype="multipart/form-data">
        <%--<form:errors path="*" cssClass="alert alert-danger" element="div"/>--%>
        <div class="form-group">
            <label for="name">Chuyến số</label>
            <form:input type="text" id="name" path="name" class="form-control"/>
            <form:errors path="name" cssClass="text-danger" element="div"/>
        </div>
        <div class="form-group">
            <label style="color: white"
                   for="datetime">Ngày</label>
            <div class="form-field">

                <form:input type="date" path="datetime"
                            class="form-control datetimepicker-input"
                            placeholder="Check-in date"
                            style="border: 1px solid black; color:black"
                            data-target="#reservationdate" />
                <form:errors path="datetime"
                             cssClass="alert alert-danger"
                             element="div" />
            </div>
        </div>
           <div class="form-group">
                                        <label for="guests">Chọn giờ</label>
                                        <div class="form-field">
                                            <i class="icon icon-arrow-down3"></i>
                                            <form:select name="people" id="time" path="time" class="form-control">
                                                <option value="0:00">0:00 </option>
                                                <option value="1:00">1:00 </option>
                                                <option value="2:00">2:00 </option>
                                                <option value="3:00">3:00 </option>
                                                <option value="4:00">4:00 </option>
                                                <option value="5:00">5:00 </option>
                                                <option value="6:00 ">6:00 </option>
                                                <option value="7:00">7:00 </option>
                                                <option value="8:00">8:00 </option>
                                                <option value="9:00">9:00 </option>
                                                <option value="10:00">10:00 </option>
                                                <option value="11:00">11:00 </option>
                                                <option value="12:00">12:00 </option>
                                                
                                            </form:select>
                                        </div>
                                    </div>
                <div class="form-group">
        <label for="cate">Tuyến</label>
        <form:select id="cate" path="idroute" class="form-control">
            <c:forEach items="${locations}" var="cat">
                <option value="${cat.id}">${cat.name}</option>
            </c:forEach>
        </form:select>
        <%--<form:input type="text" id="cate" path="category" cssClass="form-control"/>--%>
        
    </div>
         <div class="form-group">
        <label for="price">Giá</label>
        <form:input type="text" id="price" path="price" class="form-control"/>
        <form:errors path="price" cssClass="text-danger" element="div"/>
    </div>


        <br>
        <div class="form-group">
            <input type="submit" value="THÊM CHUYẾN" class="btn btn-success"/>
        </div>

    </form:form>

</section>
