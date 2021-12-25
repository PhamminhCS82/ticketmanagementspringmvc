<%-- 
    Document   : base2
    Created on : Dec 21, 2021, 8:55:16 PM
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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/style2.css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">

    </head>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.6.0/js/bootstrap.min.js"></script>
    <body>
        <div class="container-lg">
            <!--HEADER-->
            <tiles:insertAttribute name="header" />
            <!--CONTENT-->
            <tiles:insertAttribute name="content" />
            <!--FOOTER-->
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>