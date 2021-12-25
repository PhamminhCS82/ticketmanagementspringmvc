<%-- 
    Document   : route
    Created on : Dec 18, 2021, 9:43:01 AM
    Author     : LocNe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('resources/images/bg_1.jpg');">
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

                <div class="row">
                    <c:forEach var="p" items="${routeTrip}">
                        <div class="col-lg-12 col-md-4 col-sm-6">
                            <div class="card-body">                                         


                                <div >
                                    <h6>${p.name}</h6>
                                    <h5>${p.time} </h5>
                                    <h5>${p.idroute.start} </h5>
                                    <h5>${p.idroute.finish} </h5>
                                    <a href="<c:url value="/trip/${p.id}" />">Thông tin vé</a>
                                </div>

                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>
