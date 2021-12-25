<%-- 
    Document   : admin
    Created on : Dec 6, 2021, 9:55:08 AM
    Author     : pminh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin" var="action" />
<h1>Thống kế chuyến theo tuyến </h1>   

<div class="col-md-10"  >
    <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>
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
                                    <th>Time</th>
                                    <th>Tổng tuyến</th>

                                </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${totalbyMonth}" var="t">
                                <tr>  

                                    <td>                                         
                                        ${t[0]}/${t[1]}                                  
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
    let monthLabels = [], totalInfo = [];
    <c:forEach var="t" items="${totalbyMonth}">
        monthLabels.push('${t[1]}')
            totalInfo.push(${t[2]})
        </c:forEach>
    window.onload = function () {
        MothChart("myChart", monthLabels, totalInfo);
    }
</script>
 <script src="../resources/js/admin.js"></script>