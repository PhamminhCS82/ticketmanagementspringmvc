<%-- 
    Document   : signin
    Created on : Dec 8, 2021, 9:19:15 AM
    Author     : pminh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('images/bg_1.jpg');">
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
                
<section class="ftco-section ftco-no-pb contact-section mb-4">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 order-md-last d-flex">
                <c:url value="/signin" var="action" />
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger">
                        Đã có lỗi xảy ra!!!
                    </div>
                </c:if>
                <form method="post" action="${action}" class="bg-light p-5 contact-form">
                    <div class="form-group">
                        <input type="text" id="username" name="username" class="form-control" placeholder="Tài khoản">
                    </div>
                    <div class="form-group">
                        <input type="password" id="password" name="password" class="form-control" placeholder="Mật khẩu">
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Đăng nhập" class="btn btn-primary py-3 px-5">
                    </div>
                </form>
                    

            </div>
        </div>
    </div>
</section>
