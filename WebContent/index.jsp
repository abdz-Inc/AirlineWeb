
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>Login Page</title>
  <style>
    body {
      background: linear-gradient(to right, #4e54c8, #002D62);
      font-family: Arial, sans-serif;
    }
    
    .container {
      width: 300px;
      margin: 0 auto;
      margin-top: 100px;
      background-color: #fff;
      border-radius: 5px;
      padding: 20px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    
    h2 {
      text-align: center;
    }
    
    .form-group {
      margin-bottom: 20px;
    }
    
    .form-group label {
      display: block;
      font-weight: bold;
    }
    
    .form-group input {
      width: 100%;
      padding: 5px;
      border: 1px solid #ccc;
      border-radius: 3px;
    }
    
    .btn {
      width: 100%;
      background-color: #4CAF50;
      color: #fff;
      border: none;
      padding: 10px;
      font-size: 16px;
      cursor: pointer;
      border-radius: 3px;
    }
    
    .btn:hover {
      background-color: #45a049;
    }
    
    .link {
      text-align: center;
      margin-top: 10px;
    }
  </style>
</head>
<body>
<center>
	<h1 style="color:white;">
		Airline Ticket Reservation System
	</h1>
</center>
  <div class="container">
	
    <h2>Login</h2>
     <% if ( request.getAttribute("isNotValid") != null && (boolean) request.getAttribute("isNotValid")) { %>
    <h6 style="color:red;" >Invalid login</h6>
  	<% } %>
    <form action="LoginServlet" method="post">
      <div class="form-group">
        <label for="gmail">Gmail:</label>
        <input type="text" id="username" name="gmail" required>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
      </div>
      <button type="submit" class="btn">Login</button>
    </form>
    <div class="link">
      <a href="adminlogin.jsp">Admin Login</a> | <a href="signup.jsp">Sign Up</a>
    </div>
  </div>
</body>
</html>
