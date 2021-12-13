<%-- 
    Document   : baseadmin
    Created on : Dec 6, 2021, 7:21:18 PM
    Author     : pminh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" /></title>
        <link rel="stylesheet" href="bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Arizonia&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="resources1/resources/css/animate.css">
        <link rel="stylesheet" href="resources1/resources/css/owl.carousel.min.css">
        <link rel="stylesheet" href="resources1/resources/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="resources1/resources/css/magnific-popup.css">
        <link rel="stylesheet" href="resources1/resources/css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="resources1/resources/css/jquery.timepicker.css">
        <link rel="stylesheet" href="resources1/resources/css/flaticon.css">
        <link rel="stylesheet" href="resources1/resources/css/style.css">
        	<!-- Basic Page Info -->
	<meta charset="utf-8">
	<title>DeskApp - Bootstrap Admin Dashboard HTML Template</title>

	<!-- Site favicon -->
	<link rel="apple-touch-icon" sizes="180x180" href="resources1/vendors/images/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="resources1/vendors/images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="resources1/vendors/images/favicon-16x16.png">

	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="resources1/vendors/styles/core.css">
	<link rel="stylesheet" type="text/css" href="resources1/vendors/styles/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="resources1/src/plugins/datatables/css/dataTables.bootstrap4.min.css">
	<link rel="stylesheet" type="text/css" href="resources1/src/plugins/datatables/css/responsive.bootstrap4.min.css">
	<link rel="stylesheet" type="text/css" href="resources1/vendors/styles/style.css">

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag(){dataLayer.push(arguments);}
		gtag('js', new Date());

		gtag('config', 'UA-119386393-1');
	</script>
    </head>
    <body>
        <div>
             <!--HEADER-->
            <tiles:insertAttribute name="header" />
            <!--CONTENT-->
            <tiles:insertAttribute name="content" />
            <!--FOOTER-->
            <tiles:insertAttribute name="left" />
        
       
        </div>
        
              
        	<script src="resources1/vendors/scripts/core.js"></script>
	<script src="resources1/vendors/scripts/script.min.js"></script>
	<script src="resources1/vendors/scripts/process.js"></script>
	<script src="resources1/vendors/scripts/layout-settings.js"></script>
	<script src="resources1/src/plugins/apexcharts/apexcharts.min.js"></script>
	<script src="resources1/src/plugins/datatables/js/jquery.dataTables.min.js"></script>
	<script src="resources1/src/plugins/datatables/js/dataTables.bootstrap4.min.js"></script>
	<script src="resources1/src/plugins/datatables/js/dataTables.responsive.min.js"></script>
	<script src="resources1/src/plugins/datatables/js/responsive.bootstrap4.min.js"></script>
	<script src="resources1/vendors/scripts/dashboard.js"></script>
    </body>
</html>
