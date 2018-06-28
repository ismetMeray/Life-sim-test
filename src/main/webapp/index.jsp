<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="robots" content="noindex">

<title>LifeSim</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">
<link href="<s:url value='/common/css/homePage.css'/>" 
		rel="stylesheet"/>
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>

	<body>
			<div class="background">
				<div>
					<s:if test="hasActionErrors()">
						<div class="alert alert-danger">
	      			 		<s:actionerror class="error-message"/>
 						</div>
					</s:if>
					<s:if test="hasActionMessages()">
						<div class="alert alert-success">
							<s:actionmessage class="error-message"/>
						</div>
					</s:if>
					<div class="container login-form">
						<form action="userLogin" class="form-group" method="POST">
							<s:bean name="project.hospital.domain.security.Account" var="account">
								<s:textfield class="form-control un-margin-bot-5" type="text" placeholder="Username" name="account.userName" required=""/>
								<s:textfield class="form-control un-margin-bot-5" type="password" placeholder="Password" name="account.passWord" required=""/>
								<button type="submit" class="btn btn-block btn-success ">Login</button>
							</s:bean>
						</form>
						<p><a data-toggle="modal" href="#createAccountModal">Creëer een account</a></p>
						<p><a data-toggle="modal" href="#resetPasswordSetup">Wachtwoord vergeten</a></p>
						<p style="color: white;"><a class="btn" href="quickUser.action">Maak User</a>username: student password: test</p>
					</div>
				</div>
			</div>
		</body>
		
		<!-- Modals -->
		<div id="createAccountModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
 				<div class="modal-content">
			      	<div class="modal-header">
			        	<button type="button" class="close" data-dismiss="modal">&times;</button>
			        	<h4 class="modal-title text-center ">Maak een account aan</h4>
			        	
			      	</div>
			      	<form action="createAccount" method="post" data-parsley-validate>
				      	<s:bean name="project.hospital.domain.security.Account" var="account">
					      	<div class="modal-body">
								<div class="form-group">
									<label id="labelCreate"> Username</label>
									<s:textfield id="createAccountUsername" class="form-control" type="text" placeholder="Enter Username" name="userName" data-parsley-minlength="5" required=""/>
								</div>
								<div class="form-group">
									<label id="labelCreate"> Password </label>
									<s:textfield id="password-field-one" class="form-control" type="password" placeholder="Enter Password" name="passWord" required=""/>
								</div>
								<div class="form-group">
									<label id="labelCreate"> Confirm Password</label>
									<input class="form-control" type="password" placeholder="Enter Password" data-parsley-equalto="#password-field-one" required>
								</div>
								<div class="form-group">
									<label id="labelCreate">  Email </label>
									<s:textfield class="form-control" type="email" placeholder="Enter Email" name="email" required=""/>
								</div>
					      	</div>
					      	<div class="modal-footer">
					      		<button type="submit" class="btn btn-success">Submit</button>
					      		<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					      	</div>
					    </s:bean>
			      	</form>
   				</div>
			</div>
		</div>
		
		<div id="resetPasswordSetup" class="modal fade" role="dialog">
			<div class="modal-dialog">
 				<div class="modal-content">
			      	<div class="modal-header">
			        	<button type="button" class="close" data-dismiss="modal">&times;</button>
			        	<h4 class="modal-title text-center ">Reset wachtwoord</h4>
			      	</div>
			      	<form action="resetPasswordSetup" method="post" data-parsley-validate>
				      	<s:bean name="project.hospital.domain.security.Account" var="account">
					      	<div class="modal-body">
								<div class="form-group">
									<label> Email </label>
									<s:textfield id="deerzet" class="form-control" type="email" placeholder="Enter Email" name="account.email" required=""/>
								</div>
					      	</div>
					      	<div class="modal-footer">
					      		<button type="submit" class="btn btn-success">Submit</button>
					      		<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					      	</div>
					    </s:bean>
			      	</form>
   				</div>
			</div>
		</div>
</html>