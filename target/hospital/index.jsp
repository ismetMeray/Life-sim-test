<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="robots" content="noindex">

<title>Pasimo</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<link rel="stylesheet" href="<s:url value='/common/css/homePage.css'/>" />


<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>



</head>

<body>
	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">

					<div class="inner">

						<h1 class="masthead-brand">Pasimo</h1>

						<ul class="nav masthead-nav">

							<li class="active"><a href="#">About Us</a></li>

							<li><a href="#">Contact</a></li>

							<li><a href="http://www.delphinity.nl" target="_blank">Part
									of Delphinity Development</a></li>
							<!-- Add logo of Delphinity in span tags -->

						</ul>
					</div>
				</div>

				<div class="inner cover">
					<h1 class="cover-heading">Pasimo Home Page</h1>

					<p class="lead">
						Pasimo, de applicatie voor de aanwezigheidsregistratie van
						studenten en docenten. 
					</p>

					<p class="lead">
						<a class="btn btn-primary btn-sm login-button"
							href="<s:url action='security/showLogin'/>">Log In</a> <a
							class="btn btn-primary btn-sm login-button"
							href="<s:url action='showRegister'/>">Register</a>
					</p>
				</div>

				<div class="mastfoot">
					<div class="inner">
						<!-- Validation -->


						<p>
							Copyright &copy; 2018 Pasimo Development Group ~ <a
								href="http://getbootstrap.com/">Bootstrap</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>