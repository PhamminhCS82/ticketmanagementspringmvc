<%-- 
    Document   : passengercarStats
    Created on : Dec 24, 2021, 3:51:59 PM
    Author     : LocNe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/pass-stats" var="action" />
<h1>Quản lý xe </h1>   
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
                       Tài xế theo chuyến</h4>
                    </header>
                    <div class="table-wrapper-scroll-y my-custom-scrollbar">
                        <table class="table table-bordered table-striped mb-0">
                            <thead>
                                <tr>                  
                                    <th>Tên Người Lái</th>
                                    
                                    <th>Số hiệu xe</th>
                                    <th>Chuyến</th>
                                    <th><a href="<c:url value="/admin/add-passs"/>"><i class="fa fa-plus">Thêm chuyến cho xe</i></a></th>
                                </tr>
                            </thead>
                            <tbody>
                                  
                                <c:forEach items="${passStats}" var="c">
                                    <tr>         
                                        <td>${c[1]}</td>
                                        <td>${c[2]}</td>
                                        <td>${c[3]}</td>
                                   
                                        
                                        <td><div class="w3-xlarge"><a href="<c:url value="/admin/pass-stats/${c[0]}"/>?edit=${c[0]}"><i class="fa fa-pencil-square-o"></i></a></div></td>  
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