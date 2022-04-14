
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
   integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
    <link href="/css/style.css" rel="stylesheet">
    <title>User Registration</title>
</head>
<body>
<nav class="navbar navbar-light" style="background-color: #e3f2fd">
    <a class="navbar-brand">Vehicle Loan Management System</a>
    </nav>
    
    <h2>Enter the User to register:</h2>
    <form action="/api/vehicleloans/userregister" method="post">
    
    <!-- <label for="userId">User Id:</label><br>
    <input type="number" id="userId" name="userId"><br> -->
    
   <label for="Name">Name:</label><br>
    <input type="text" id="name" name="name"><br>
    
    <label for="email">Email</label><br>
    <input type="email" id="email" name="email"><br>
    
    
    
    <label for="mobile">Mobile Number</label><br>
    <input type="number" id="mobno" name="mobile"><br> <br>
    
    <legend>Choose your gender:</legend><br>
    <label for="male">Male</label>
    <input type="radio" name="gender" id="male" value="male" checked>
    <label for="female">Female</label>
    <input type="radio" name="gender" id="female" value="female"><br>
    
       <label for="age">Age </label><br>
    <input type="number" id="age" name="age"><br>
    
    <label for="password">Password:</label><br>
    <input type="text" id="password" name="password"><br>

    
   <br>
  <!--   <a href='userregister'>
    <input type="submit" id="sub" name="sub"><br>  -->
    
    <a href="userdetails" type="submit" class="btn btn-primary">Enter to fill userdetails</a>

</form>


 

    

</body>
</html>
