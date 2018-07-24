<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>Stop2Shop Login</title>

<style type="text/css">

body { 
  background: url(https://images.pexels.com/photos/850796/pexels-photo-850796.jpeg?cs=srgb&dl=background-design-marble-850796.jpg&fm=jpg) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

</style>

</head>
<body>
		
<div class="container">
		<h2 align="center">Please Sign In</h2>
		<br>
		<br>
		<c:url var="action" value="/j_spring_security_check" />
		<form name="loginForm" class="form-horizontal" action="${action}" method="post">
		
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="id"><i class="fa fa-user" aria-hidden="true"></i> Username:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="id" id="id" placeholder="Enter Username" pattern=".{5,15}" title="Username must have 5 to 15 characters" required>
				</div>
			</div>
			
			<br>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="password"><i class="fa fa-key" aria-hidden="true"></i> Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="password" id="password" placeholder="Enter password" pattern=".{5,15}" title="Password must have 5 to 15 characters" required>
				</div>
			</div>
			
			<br>
			
			<div class="form-group">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">
						<i class="fa fa-sign-in" aria-hidden="true"></i> Let Me In
					</button>
				</div>
			</div>
			<div class="container col-sm-offset-3 col-sm-9" style="color: red">${errorLoginMessage}</div>
			>
		
				</form>
				
				
	</div>
 
 
 
 
 </body>
 

 
</html>