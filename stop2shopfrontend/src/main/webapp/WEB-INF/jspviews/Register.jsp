<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stop2Shop Register</title>

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
  <h2 align="center">Free Registration</h2>
  <br>
  <form class="form-horizontal" action="Register" method="get">
  	<div class="form-group">
      <label class="control-label col-sm-2" for="uEmail"><i class="fa fa-envelope" aria-hidden="true"></i> Email:</label>
      <div class="col-sm-6">
        <input type="email" class="form-control" id="uEmail" placeholder="Enter your email id...." name="uEmail" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="uName"><i class="fa fa-user" aria-hidden="true"></i> Name:</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="uName" placeholder="Enter Name..." name="uName" required>
      </div>
      </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="uId"><i class="fa fa-user-secret" aria-hidden="true"></i> Username:</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="uId" placeholder="Enter your Username..." name="uId" pattern=".{5,15}" title="Username must have 5 to 15 characters" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="uPassword"><i class="fa fa-key" aria-hidden="true"></i> Password:</label>
      <div class="col-sm-6">          
        <input type="password" class="form-control" id="uPassword" placeholder="Enter Password" name="uPassword" pattern=".{5,15}" title="password must have 5 to 15 characters" required >
      </div>
    </div>
      <div class="form-group">
      <label class="control-label col-sm-2" for="uCountry"><i class="fa fa-globe" aria-hidden="true"></i> Country:</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="uCountry" placeholder="Enter Country" name="uCountry" required>
      </div>
      </div>
      <div class="form-group">
      <label class="control-label col-sm-2" for="uAddress"><i class="fa fa-location-arrow" aria-hidden="true"></i> Address:</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="uAddress" placeholder="Type Address" name="uAddress" required>
      </div>
      </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="uContact"><i class="fa fa-mobile" aria-hidden="true"></i> Mobile:</label>
      <div class="col-sm-6">          
        <input type="text" class="form-control" id="uContact" placeholder="Enter Mobile Number" name="uContact"  pattern="[6789][0-9]{9}" title="Mobile number should have 10 digits and should start with 6/7/8/9" required>
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-danger"><i class="fa fa-user-plus" aria-hidden="true"></i> SignUp</button>
      </div>
    </div>
    
    
  </form>
</div>

</body>
</html>