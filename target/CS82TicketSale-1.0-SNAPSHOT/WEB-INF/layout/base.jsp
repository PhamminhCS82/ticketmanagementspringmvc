<%-- 
    Document   : base
    Created on : Oct 21, 2021, 6:02:19 AM
    Author     : pminh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title><tiles:insertAttribute name="title" /></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Arizonia&display=swap" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="<c:url value="css/animate.css" />"/>
        <link type="text/css" rel="stylesheet" href="<c:url value="css/owl.carousel.min.css"/>"/>
        <link type="text/css" rel="stylesheet" href="<c:url value="css/owl.theme.default.min.css"/>"/>
        <link type="text/css" rel="stylesheet" href="<c:url value="css/magnific-popup.css"/>">
        <link type="text/css" rel="stylesheet" href="<c:url value="css/bootstrap-datepicker.css"/>"/>
        <link type="text/css" rel="stylesheet" href="<c:url value="css/jquery.timepicker.css"/>"/>
        <link type="text/css" rel="stylesheet" href="<c:url value="css/flaticon.css"/>"/>
        <link type="text/css" rel="stylesheet" href="<c:url value="css/style.css"/>"/>
    </head>
    <body>
        <div>
            <!--HEADER-->
            <tiles:insertAttribute name="header" />
            <!--CONTENT-->
            <tiles:insertAttribute name="content" />
            <!--FOOTER-->
            <tiles:insertAttribute name="footer" />
        </div>
        <script src="<c:url value="js/jquery.min.js"/>"></script>
        <script src="<c:url value="js/jquery-migrate-3.0.1.min.js"/>"></script>
        <script src="<c:url value="js/popper.min.js"/>"></script>
        <script src="<c:url value="js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="js/jquery.easing.1.3.js"/>"></script>
        <script src="<c:url value="js/jquery.waypoints.min.js"/>"></script>
        <script src="<c:url value="js/jquery.stellar.min.js"/>"></script>
        <script src="<c:url value="js/owl.carousel.min.js"/>"></script>
        <script src="<c:url value="js/jquery.magnific-popup.min.js"/>"></script>
        <script src="<c:url value="js/jquery.animateNumber.min.js"/>"></script>
        <script src="<c:url value="js/bootstrap-datepicker.js"/>"></script>
        <script src="<c:url value="js/scrollax.min.js"/>"></script>
        <script src="<c:url value="js/main.js"/>"></script>
    </body>
</html>
