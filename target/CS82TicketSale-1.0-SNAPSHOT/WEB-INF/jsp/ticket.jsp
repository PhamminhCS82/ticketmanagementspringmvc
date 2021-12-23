<%-- 
    Document   : ticket
    Created on : Dec 19, 2021, 2:15:24 PM
    Author     : LocNe
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('../resources/images/bg_1.jpg');">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-center">
            <div class="col-md-9 ftco-animate pb-5 text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="<c:url value="/" />">Trang chủ <i class="fa fa-chevron-right"></i></a></span> <span>Đăng nhập <i class="fa fa-chevron-right"></i></span></p>
                <h1 class="mb-0 bread">Đăng nhập</h1>
            </div>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <ul>
                    <li><b>Chuyến số :</b> <span> ${trip.name}</span></li>
                    <li><b>Điểm đi:</b> <span> ${trip.idroute.start}</span></li>
                    <li><b>Điểm đến:</b> <span> ${trip.idroute.finish}</span></li>
                    <li><b>Ngày/ Giờ khởi hành:</b> <span> ${trip.datetime}</span></li>
                    <li><b>Gias ve</b> <span> ${trip.price}</span></li>

                    <!--                        <label for="cate">Loại sản phẩm</label>
                    <%--<form:select id="cate" path="idcardetail" class="form-control">--%>
                    <%--<c:forEach items="${seats}" var="cat">--%>
                    <%--<form:option value="${cat.id}">${cat.name}</form:option>--%>
                    <%--</c:forEach>--%>
                    <%--</form:select>--%>
                    -->


                    <a href="#">Mua vé</a>
                </ul>

            </div>
        </div>
    </div>
</section>

