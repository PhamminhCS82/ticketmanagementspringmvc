<%-- 
    Document   : signup
    Created on : Dec 8, 2021, 9:18:58 AM
    Author     : pminh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <form action="#" class="bg-light p-5 contact-form">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Your Name">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Your Email">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Subject">
                    </div>
                    <div class="form-group">
                        <textarea name="" id="" cols="30" rows="7" class="form-control" placeholder="Message"></textarea>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Đăng ký" class="btn btn-primary py-3 px-5">
                    </div>
                </form>

            </div>
        </div>
    </div>
</section>
