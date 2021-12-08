<%-- 
    Document   : base
    Created on : Oct 21, 2021, 6:02:19 AM
    Author     : pminh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <title><tiles:insertAttribute name="title" /></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Arizonia&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="resources/css/animate.css">
        <link rel="stylesheet" href="resources/css/owl.carousel.min.css">
        <link rel="stylesheet" href="resources/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="resources/css/magnific-popup.css">
        <link rel="stylesheet" href="resources/css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="resources/css/jquery.timepicker.css">
        <link rel="stylesheet" href="resources/css/flaticon.css">
        <link rel="stylesheet" href="resources/css/style.css">
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
        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/js/jquery-migrate-3.0.1.min.js"></script>
        <script src="resources/js/popper.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/jquery.easing.1.3.js"></script>
        <script src="resources/js/jquery.waypoints.min.js"></script>
        <script src="resources/js/jquery.stellar.min.js"></script>
        <script src="resources/js/owl.carousel.min.js"></script>
        <script src="resources/js/jquery.magnific-popup.min.js"></script>
        <script src="resources/js/jquery.animateNumber.min.js"></script>
        <script src="resources/js/bootstrap-datepicker.js"></script>
        <script src="resources/js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="resources/js/google-map.js"></script>
        <script src="resources/js/main.js"></script>
    </body>
</html>
