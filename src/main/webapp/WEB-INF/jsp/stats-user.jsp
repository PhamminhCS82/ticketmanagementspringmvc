<%-- 
    Document   : stats-user
    Created on : Dec 23, 2021, 9:40:34 PM
    Author     : LocNe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/admin/user" var="action" />
<h1>Quản lý người dùng </h1>   
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
                       Tài xế</h4>
                    </header>
                    <div class="table-wrapper-scroll-y my-custom-scrollbar">
                        <table class="table table-bordered table-striped mb-0">
                            <thead>
                                <tr>                  
                                    <th>Họ</th>
                                    <th>Tên</th>
                                    <th>Username </th>   
                                    <th>Password</th>
                                    <th>Email</th>
                                    <th>Phone</th> 
                                    <th>User Role</th>
                                    
                                    <th><a href="<c:url value="/admin/add-drivers"/>"><i class="fa fa-plus">Thêm tài xế</i></a></th>
                                </tr>
                            </thead>
                            <tbody>
                                  
                                <c:forEach items="${userStats}" var="c">
                                    <tr>         
                                        <td>                                         
                                            ${c.surname}                                    
                                        </td>
                                        <td>${c.firstname}</td>
                                        <td>${c.username}</td> 
                                        <td>${c.password}</td>
                                        <td>${c.email}</td>
                                        <td>${c.phone}</td>
                                        <td>${c.userrole}</td>
                                        <td><div class="w3-xlarge"><a href="<c:url value="/admin/edit-users/${c.id}"/>?edit=${c.id}"><i class="fa fa-pencil-square-o"></i></a></div></td>  
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
                        Nhân viên</h4>
                    </header>
                    <div class="table-wrapper-scroll-y my-custom-scrollbar">
                        <table class="table table-bordered table-striped mb-0">
                            <thead>
                                <tr>                  
                                    <th>Họ</th>
                                    <th>Tên</th>
                                    <th>Username </th>   
                                    <th>Password</th>
                                    <th>Email</th>
                                    <th>Phone</th> 
                                    <th>User Role</th>
                                    
                                     <th><a href="<c:url value="/admin/add-employs"/>"><i class="fa fa-plus">Thêm nhân viên</i></a></th>
                                </tr>
                            </thead>
                            <tbody>
                                  
                                <c:forEach items="${userEmplStats}" var="u">
                                    <tr>         
                                        <td>                                         
                                            ${u.surname}                                    
                                        </td>
                                        <td>${u.firstname}</td>
                                        <td>${u.username}</td> 
                                        <td>${u.password}</td>
                                        <td>${u.email}</td>
                                        <td>${u.phone}</td>
                                        <td>${u.userrole}</td>
                                        <td><div class="w3-xlarge"><a href="<c:url value="/admin/edit-users/${u.id}"/>?edit=${u.id}"><i class="fa fa-pencil-square-o"></i></a></div></td>  
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