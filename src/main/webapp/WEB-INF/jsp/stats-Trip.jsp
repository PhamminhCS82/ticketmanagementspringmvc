<%-- 
    Document   : stats-Trip
    Created on : Dec 25, 2021, 3:04:11 PM
    Author     : LocNe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/trip-stats" var="action" />
<h1>Thống kế chuyến theo tuyến </h1>   
<br>
            <div class="col-md-6 px-2">
                <canvas id="myCateStatsChart"></canvas>
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
                                     <th>Tên</th>
                                    <th>Tổng tuyến</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                  
                                <c:forEach items="${counttripStats}" var="t">
                                    <tr>  
                                 
                                        <td>                                         
                                            ${t[1]}                                    
                                        </td>
                                 
                                        <td>${t[2]}</td>
                                        
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