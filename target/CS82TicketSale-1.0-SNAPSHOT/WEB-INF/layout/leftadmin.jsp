<%-- 
    Document   : leftadmin
    Created on : Dec 16, 2021, 11:58:20 PM
    Author     : pminh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
    <div class="sidebar-sticky pt-3">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active" href="<c:url value="/admin"/>">
                    <span data-feather="home"></span>
                    Dashboard <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/trip-stats"/>">
                    <span data-feather="file"></span>
                    Quản lý Chuyến/Tuyến
                </a>

            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/pass-stats"/>">
                    <span data-feather="shopping-cart"></span>
                    Quản lý Xe
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/user"/>">
                    <span data-feather="users"></span>
                    Quản lý nhân viên
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/state-trip"/>">
                    <span data-feather="bar-chart-2"></span>
                    Reports
                </a>
            </li>
        </ul>


    </div>
</nav>
