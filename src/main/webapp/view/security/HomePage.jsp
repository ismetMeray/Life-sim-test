<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<s:url value="/common/css/bootstrap.min.css"/>" />

<!-- Website CSS style -->
<link rel="stylesheet" href="<s:url value="/common/css/main.css"/>" />

<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="<s:url value="/common/plugins/AdminLTE/css/AdminLTE.min.css"/>" />
<link rel="stylesheet" href="<s:url value='/common/css/login_style.css'/>" />

<title>Login</title>
</head>
<body class="bg-delphini">
	<div class="container">
		<div class="row main">
			<div class="panel-heading">
				<div class="login-logo">
					<span class="logo-lg"><img
						style="height: 50px; filter: brightness(0) invert(1);"
						src="<c:url value='/images/dolphin-min.png'></c:url>" />Be<b>ZEM</b><img
						style="height: 50px; filter: brightness(0) invert(1);"
						src="<c:url value='/images/dolphin-min.png'></c:url>" /></span>
				</div>
			</div>
			<div class="main-login main-center">

				<s:actionerror class="well alert-danger errors" />

				<s:fielderror class="well alert-danger errors">
					<s:param>user</s:param>
					<s:param>pass</s:param>
				</s:fielderror>

				<form class="form-horizontal" method="post" action="doLogin" >

					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">Username</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-user fa-sm" aria-hidden="true"></i></span>
								<s:textfield name="account.userName" class="form-control"
									placeholder="Enter your Username"></s:textfield>

							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-sm" aria-hidden="true"></i></span>

								<s:password name="account.passWord" class="form-control"
									placeholder="Enter your Password"></s:password>

							</div>
						</div>
					</div>



					<div class="form-group ">
<!-- ******* No need for dynamic method invokation here. Thus, method = "login" can be omitted. Method call is specified in struts-security.xml ********* -->					
						<s:submit method="login" value="Login" align="center"
							class="btn btn-primary btn-lg btn-block login-button" />
					</div>
					<div class="login-register">

						<a href="<s:url action='showRegister'/>">Register</a> - <a
							href="<s:url action='showForgotPassword'/>">Forgot Password</a>

					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="common/js/bootstrap.js"></script>
</body>
</html>