<%-- 
    Document   : signup
    Created on : Dec 8, 2021, 9:18:58 AM
    Author     : pminh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('resources/images/bg_1.jpg');">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-center">
            <div class="col-md-9 ftco-animate pb-5 text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="<c:url value="/" />">Trang chủ <i class="fa fa-chevron-right"></i></a></span> <span>Đăng ký <i class="fa fa-chevron-right"></i></span></p>
                <h1 class="mb-0 bread">Đăng ký</h1>
            </div>
        </div>
    </div>
</section>
<section class="ftco-section ftco-no-pb contact-section mb-4">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 order-md-last d-flex">
                <c:if test="${errMsg != null}">
                    <div class="alert alert-danger">
                        ${errMsg}
                    </div>
                </c:if>
                <c:url value="/signin" var="action"/>
                <form:form method="post" action="${action}" modelAttribute="user" class="bg-light p-5 contact-form">
                    <div class="form-group">
                        <form:input type="text" id="firstname" path="firstname" class="form-control" placeholder="Tên"/>
                    </div>
                    <div class="form-group">
                        <form:input type="text" id="lastname" path="surname" class="form-control" placeholder="Họ"/>
                    </div>
                    <div class="form-group">
                        <form:input type="text" id="email" path="email" class="form-control" placeholder="Email"/>
                    </div>
                    <div class="form-group">
                        <form:input type="phone" id="phonenum" path="phone" class="form-control" placeholder="Số điện thoại"/>
                    </div>
                    <div class="form-group">
                        <form:input type="text" id="username" path="username" class="form-control" placeholder="Tài khoản"/>
                    </div>
                    <div class="form-group">
                        <form:input type="password" id="password" path="password" class="form-control" placeholder="Mật khẩu"/>
                    </div>
                    <div class="form-group">
                        <form:input type="password" id="confirmPassword" path="confirmPassword" class="form-control" placeholder="Nhập lại mật khẩu"/>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Đăng ký" class="btn btn-primary py-3 px-5">
                    </div>
                </form:form>

            </div>
        </div>
    </div>
</section>
