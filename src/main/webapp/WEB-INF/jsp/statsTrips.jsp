<%-- 
    Document   : statsTrips
    Created on : Dec 22, 2021, 9:10:33 PM
    Author     : LocNe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/trip-stats" var="action" />
<h1>Quản lý Tuyến/Chuyến</h1>   
<br>
                
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
                                    <th><a href="<c:url value="/admin/add-routes"/>"><i class="fa fa-plus">Thêm tuyến</i></a></th>
                                </tr>
                            </thead>
                            <tbody>
                                  
                                <c:forEach items="${tripStats}" var="c">
                                    <tr>         
                                        <td>${c[1]}</td>
                                        <td>${c[2]}</td>
                                        <td>${c[3]}</td>   
                                        <td><div class="w3-xlarge"><a href="<c:url value="/admin/edit-routes/${c[0]}"/>?edit=${c[0]}"><i class="fa fa-pencil-square-o"></i></a></div>
                                         <div class="w3-xlarge"><a href="<c:url value="/admin/route-delete/${c[0]}"/>"><i class="fa fa-trash"></i></a></div></td>  
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
                                    <th>Giá</th> 
                                    <th><a href="<c:url value="/admin/add-trips"/>"><i class="fa fa-plus">Thêm tuyến</i></a></th>
                                </tr>
                            </thead>
                            <tbody>
                                  
                                <c:forEach items="${routeStats}" var="r">
                                    <tr>  
                                        <td>${r[4]}</td>
                                        <td>                                         
                                            ${r[1]}                                    
                                        </td>
                                        <td>${r[3]}</td>
                                        <td>${r[2]}</td>
                                        <td><div class="w3-xlarge"><a href="<c:url value="/admin/edit-trips/${r[0]}"/>?edit=${r[0]}"><i class="fa fa-pencil-square-o"></i></a></div>
                                         <div class="w3-xlarge"><a href="<c:url value="/admin/trip-delete/${r[0]}"/>"><i class="fa fa-trash"></i></a></div></td>  
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
    <c:forEach items="${counttripStats}" var="t">
    productLables.push('${t[1]}')
    productInfo.push('${t[2]}')
    </c:forEach>
   
    window.onload = function () {
        cateChart("myCateStatsChart", productLables, productInfo)
    }
</script>
 <script src="../resources/js/stats.js"></script>