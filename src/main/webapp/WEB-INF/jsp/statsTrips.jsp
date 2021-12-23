<%-- 
    Document   : statsTrips
    Created on : Dec 22, 2021, 9:10:33 PM
    Author     : LocNe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Số lượng sản phẩm theo loại sản phẩm </h1>   
<br>
            <div >
                <canvas id="myCateStatsChart"></canvas>
            </div>       
<div class="card panel">
    <div class="row ">
        <div class="col-md-12 px-2">
            <div >
                <section class="panel">
                    <header class="panel-heading no-border"><h4>
                        Tất cả các tuyến</h4>
                    </header>
                    <div class="table-wrapper-scroll-y my-custom-scrollbar">
                        <table class="table table-bordered table-striped mb-0">
                            <thead>
                                <tr>                  
                                    <th>Tên chuyến</th>
                                    <th>Điểm đi</th>
                                    <th>Điểm đến </th>   
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                  
                                <c:forEach items="${tripStats}" var="c">
                                    <tr>         
                                        <td>                                         
                                            ${c[1]}                                    
                                        </td>
                                        <td>${c[2]}</td>
                                        <td>${c[3]}</td>   
                                        <td><div class="w3-xlarge"><a href="<c:url value="/edit-routes/${c[0]}"/>?edit=${c[0]}"><i class="fa fa-pencil-square-o"></i></a></div>
                                         <div class="w3-xlarge"><a href="<c:url value="/route-delete/${c[0]}"/>"><i class="fa fa-trash"></i></a></div></td>  
                                    </tr>
                                </c:forEach>                            
                            </tbody>
                        </table>
                    </div> 
                </section>
            </div>          
        </div>
        <!-- End of carousel -->
    </div>
</div>

<div class="card panel">
    <div class="row ">
        <div class="col-md-12 px-2">
            <div >
                <section class="panel">
                    <header class="panel-heading no-border"><h4>
                        Tất cả các chuyến</h4>
                    </header>
                    <div class="table-wrapper-scroll-y my-custom-scrollbar">
                        <table class="table table-bordered table-striped mb-0">
                            <thead>
                                <tr>
                                     <th>Tên tuyến</th>
                                    <th>Tên chuyến</th>
                                    <th>Ngày đi</th>
                                    <th>Giờ khởi hành </th>  
                                    <th>Giá</th> 
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                  
                                <c:forEach items="${routeStats}" var="c">
                                    <tr>  
                                        <td>${c[5]}</td>
                                        <td>                                         
                                            ${c[1]}                                    
                                        </td>
                                        <td>${c[3]}</td>
                                        <td>${c[4]}</td>
                                        <td>${c[2]}</td>
                                        <td><div class="w3-xlarge"><a href="<c:url value="/edit-trips/${c[0]}"/>?edit=${c[0]}"><i class="fa fa-pencil-square-o"></i></a></div>
                                         <div class="w3-xlarge"><a href="<c:url value="/trip-delete/${c[0]}"/>"><i class="fa fa-trash"></i></a></div></td>  
                                    </tr>
                                </c:forEach>                            
                            </tbody>
                        </table>
                    </div> 
                </section>
            </div>          
        </div>
        <!-- End of carousel -->
    </div>
</div>
<script>
    let productLables = [], productInfo = [];
    <c:forEach items="${tripStats}" var="c">
    productLables.push('${c[0]}')
    productInfo.push('${c[1]}')
    </c:forEach>
   
    window.onload = function () {
        cateChart("myCateStatsChart", productLables, productInfo)
    }
</script>