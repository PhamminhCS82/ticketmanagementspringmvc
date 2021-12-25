<%-- 
    Document   : index
    Created on : Sep 23, 2021, 12:27:53 AM
    Author     : pminh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="hero-wrap js-fullheight" style="background-image: url('resources/images/bg_5.jpg');">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
            <div class="col-md-9 ftco-animate pb-5 text-center">
                <span class="subheading">Đồ án cuối kì</span>
                <h1 class="mb-4">Đặt mua vé xe khách</h1>
                <p class="caps">Đi đến mọi cung đường</p>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section ftco-no-pb ftco-no-pt">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="ftco-search d-flex justify-content-center">
                    <div class="row">
                        <div class="col-md-10 nav-link-wrap">
                            <div class="nav nav-pills text-center" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                                <a class="nav-link active mr-md-1" id="v-pills-1-tab" data-toggle="pill" href="#v-pills-1" role="tab" aria-controls="v-pills-1" aria-selected="true">Tìm chuyến</a>


                            </div>
                        </div>
                        <div class="col-md-12 tab-wrap">

                            <div class="tab-content" id="v-pills-tabContent">

                                <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="v-pills-nextgen-tab">
                                    <form action="#" class="search-property-1">
                                        <div class="row no-gutters">
                                            <div class="col-md d-flex">
                                                <div class="form-group p-4 border-0">
                                                    <label for="start">Điểm đi</label>
                                                    <div class="form-field">
                                                        <div class="icon"><span class="fa fa-bus"></span></div>
                                                        <input type="text" class="form-control" placeholder="Search place">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md d-flex">
                                                <div class="form-group p-4">
                                                    <label for="#">Điểm đến</label>
                                                    <div class="form-field">
                                                        <div class="icon"><span class="fa fa-bus"></span></div>
                                                        <input type="text" class="form-control" placeholder="Search place">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md d-flex">
                                                <div class="form-group p-4">
                                                    <label for="#">Ngày đi</label>
                                                    <div class="form-field">
                                                        <div class="icon"><span class="fa fa-calendar"></span></div>
                                                        <input type="text" class="form-control checkin_date" placeholder="Check In Date">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md d-flex">
                                            </div>
                                            <div class="col-md d-flex">
                                                <div class="form-group d-flex w-100 border-0">
                                                    <div class="form-field w-100 align-items-center d-flex">
                                                        <input type="submit" value="Tìm kiếm" class="align-self-stretch form-control btn btn-primary">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</section>


<section>
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <c:forEach var="p" items="${locations}">
                    <div class="card">

                        <c:url value="/route" var="catPath">
                            <c:param name="CateId" value="${p.id}"></c:param>
                        </c:url>
                        <a class="nav-link" href="${catPath}"">${p.name}</a>
                    </div>
                </c:forEach>

            </div>
        </div>
        <ul class="pagination justify-content-center">
            <c:forEach begin="1" end="${Math.ceil(counter/6)}" var="i">
                <li class="page-item"><a class="page-link" href="<c:url value="/route"/>?page=${i}">${i}</a></li>
                </c:forEach>
        </ul></div>

</section>




<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center pb-4">
            <div class="col-md-12 heading-section text-center ftco-animate">
                <span class="subheading">Danh sách</span>
                <h2 class="mb-4">Các Tuyến</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 ftco-animate">
                <div class="project-wrap">
                    <a href="#" class="img" style="background-image: url('resources/images/destination-1.jpg');">
                        <span class="price">$550/person</span>
                    </a>
                    <div class="text p-4">
                        <span class="days">8 Days Tour</span>
                        <h3><a href="#">Banaue Rice Terraces</a></h3>
                        <p class="location"><span class="fa fa-map-marker"></span> Banaue, Ifugao, Philippines</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
