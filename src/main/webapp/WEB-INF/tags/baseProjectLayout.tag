<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@attribute name="contentheader" fragment="true"%>
<%@attribute name="content" fragment="true"%>
<%@attribute name="scripts" fragment="true"%>
<%@attribute name="css" fragment="true"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Pasimo</title>

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/t/bs-3.3.6/jq-2.2.0,dt-1.10.11,r-2.0.2,se-1.1.2/datatables.min.css" />

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/css/select2.min.css">
<!-- End Of Font Awesome -->

<!-- Theme style -->
<link rel="stylesheet"
	href="<s:url value='/common/plugins/AdminLTE/css/AdminLTE.min.css'/>" />
<!-- 	Probably not necessary. -->
<link rel="stylesheet"
	href="<s:url value='/common/css/main_style.css'/>" />
<link rel="stylesheet"
	href="<s:url value='/common/plugins/AdminLTE/css/skins/skin-blue.min.css'/>" />
<!-- End Of Theme style -->
<jsp:invoke fragment="css" />


</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div data-slideback="true" data-target="notifybar" id="notifybar"
		class="slide notification-bar"></div>

	<!-- Wrapper -->
	<div id="main-wrapper" class="wrapper">

		<!-- Main Header -->
		<header class="main-header">

			<!-- Logo -->

			<a href="<s:url value='/index.jsp'/>" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini">Sim</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Simu</b>Lator<img
					style="height: 50px;"
					src="<s:url value="/images/download.png"></s:url>" /></span>
			</a>

			<!-- /.Logo -->

			<!-- Header Navbar -->

			<nav class="navbar navbar-static-top" role="navigation">

				<!-- Sidebar toggle button-->

				<a href="<s:url value="#"/>" class="sidebar-toggle"
					data-toggle="offcanvas" role="button"> <span class="sr-only">Toggle
						navigation</span>
				</a>

				<!-- /.Sidebar toggles button-->

				<!-- Header Custom Menu -->

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- User Account Menu -->

						<li class="dropdown user user-menu">
							<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <!-- The user image in the navbar-->
								<img
								src="<s:url value="/images/avatars/Albert Einstein.jpg"></s:url>"
								class="user-image" alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. -->
								<span class="hidden-xs">Welcome,
									</span>
						</a>
							<ul class="dropdown-menu">
								<!-- The user image in the menu -->
								<li class="user-header">
									<!-- Provide a dynamic Image of user here. For now Albert will do for all accounts -->
									<img
									src="<s:url value="/images/avatars/Albert Einstein.jpg"></s:url>"
									class="img-circle" alt="User Image">

									<p>
										<small></small>
									</p>
								</li>

								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="">
										<a href="<s:url action='doLogout'/>"
											class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul>
						</li>
					</ul>
				</div>

				<!-- /.Header Custom Menu -->

			</nav>

			<!-- /.Header Navbar -->

		</header>


		<!-- Left side column. Contains the sidebar -->

		<aside class="main-sidebar">

			<!-- Section watte? -->

			<section class="sidebar">

				<!-- Sidebar Menu -->

				<ul class="sidebar-menu">
					<li class="header">Pasimo navigation</li>

					<!-- Menu Items -->
					<!-- Optionally, you can add icons to the links -->
					<!-- ******************** Teacher ******************** -->
					<li><a
						href="<s:url action="TeacherOverview" namespace="/teacher"/>">
							<i class="glyphicon glyphicon-user"></i><span> Show
							Charachters</span>
					</a></li>

					<li><a
						href="<s:url action="Studentview" namespace="/student"/>"><i
							class="glyphicon glyphicon-credit-card"></i> <span>Show
							Profile</span></a></li>

					<li><a href="<s:url action="showEducationTeam"/>"><i
							class="fa fa-university"></i> <span>Friends</span></a></li>

					<!-- **************************** Start of menu educationteams **************************** -->

					<li><a href="<s:url action="educationTeam" namespace="/educationteam"/>">
							<i class="fa fa-users"></i><span> Clan</span>
					</a></li>
					<!-- **************************** Start of menu lessongroups **************************** -->

					
			<!-- /.Section -->

		</aside>

		<!-- /.Left side column -->

		<!-- Content Wrapper. Contains page content -->

		<div class="content-wrapper bg-delphini">
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
				<a href="http://portfolioim.atwebpages.com/">Part of <strong>Ismet
						Software Engineering</strong></a> <img style="height: 100%"
					src="<s:url value ="/images/download.png"/>" />
			</div>

			<!-- /images/scalda-logo-sm.png -->
			<!-- Default to the left -->
			<s:set var="start" value="%{'2017'}"></s:set>
			<s:action name="dateTag" var="now" executeResult="false"></s:action>
			<s:property
					value="#now.currentYear" /> <a href="#">Ismet Development Man</a>.
			I stole from google
		</footer>

	</div>

	<!-- /.Wrapper -->


	<!-- REQUIRED JS SCRIPTS -->



	<!-- jQuery 2.2.3 -->
	<script type="text/javascript"
		src="<s:url value="/common/plugins/jQuery/jquery-2.2.3.min.js" />"></script>
	<!-- Bootstrap 3.3.6 -->
	<script type="text/javascript"
		src="<s:url value="/common/js/bootstrap.min.js" />"></script>
	<!-- AdminLTE App -->
	<script type="text/javascript"
		src="<s:url value="/common/plugins/AdminLTE/js/app.min.js" />"></script>


	<jsp:invoke fragment="scripts" />
</body>



</html>