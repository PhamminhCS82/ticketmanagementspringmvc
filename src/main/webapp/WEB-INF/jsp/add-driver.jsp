<%-- 
    Document   : add-driver
    Created on : Dec 29, 2021, 10:13:25 PM
    Author     : LocNe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section class="ftco-section ftco-no-pb contact-section mb-12">
    <div class="container">
        <c:if test="${errMsg != null}">
            <div class="alert alert-danger">
                ${errMsg}
            </div>
        </c:if>
        <div class="row justify-content-center">

            <div class="col-md-12 ">

                <c:url value="/admin/add-drivers" var="action"/>
                <form:form method="post" action="${action}" modelAttribute="user" class="bg-light p-5 contact-form" enctype="multipart/form-data">
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
