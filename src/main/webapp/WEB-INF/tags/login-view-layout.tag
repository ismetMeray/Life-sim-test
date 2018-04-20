<%@tag import="java.text.SimpleDateFormat"%>
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="contentheader" fragment="true"%>
<%@attribute name="content" fragment="true"%>
<%@attribute name="scripts" fragment="true"%>
<%@attribute name="css" fragment="true"%>



<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Scalda AO</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/t/bs-3.3.6/jq-2.2.0,dt-1.10.11,r-2.0.2,se-1.1.2/datatables.min.css" />
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/css/select2.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/AdminLTE/css/AdminLTE.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/parsley.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/content.css"/>" />


<link rel="stylesheet"
	href="<c:url value="/resources/plugins/AdminLTE/css/skins/skin-blue.min.css"/>" />
<jsp:invoke fragment="css" />


</head>

<body class="hold-transition skin-blue sidebar-collapse">
	<div id="main-wrapper" class="wrapper">

		<!-- Main Header -->
		<header class="main-header">

			<!-- Logo -->
			<a  class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini">AO</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><img
					style="height: 50px; filter: brightness(0) invert(1);"
					src="<c:url value="/resources/images/Logo.png"></c:url>" /></span>
			</a>

			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->

			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<section class="content-header">
				<jsp:invoke fragment="contentheader" />
			</section>
			<section class="content">
				<jsp:invoke fragment="content" />
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<footer class="main-footer">
			<!-- To the right -->
			<div style="height: 30px" class="pull-right image hidden-xs">

			</div>
			<!-- Default to the left -->
			<strong><a href="http://www.scalda.nl">Scalda</a> <c:set
					var="now"
					value="<%=new java.util.GregorianCalendar().get(java.util.GregorianCalendar.YEAR)%>" />
				<c:out value="${now}"></c:out> </strong>
		</footer>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED JS SCRIPTS -->
	<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>

	<!-- jQuery 2.x -->
	<script src="https://code.jquery.com/jquery-2.2.3.min.js"
		integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo="
		crossorigin="anonymous"></script>

	<!-- Bootstrap 3.3.6 -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
		crossorigin="anonymous"></script>
	<!-- AdminLTE App -->

	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap4.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js"></script>

	<jsp:invoke fragment="scripts" />
</body>
</html>
