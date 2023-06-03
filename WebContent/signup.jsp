<!DOCTYPE html>
<html>
<head>
  <title>Sign Up</title>
  <style>
  body {
      background: linear-gradient(to right, #4e54c8, #8f94fb);
      font-family: Arial, sans-serif;
    }
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }

    .container {
      max-width: 400px;
      margin: 20px auto;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }

    h1 {
      text-align: center;
      margin-bottom: 20px;
    }

    .form-group {
      margin-bottom: 10px;
    }

    .form-group label {
      display: block;
      margin-bottom: 5px;
    }

    .form-group input[type="text"],
    .form-group input[type="email"],
    .form-group input[type="password"],
    .form-group input[type="tel"] {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .form-group input[type="submit"] {
      width: 100%;
      padding: 8px;
      border: none;
      border-radius: 4px;
      background-color: #4CAF50;
      color: white;
      cursor: pointer;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>Sign Up</h1>
     <% if ( request.getAttribute("isNotValid") != null && (boolean) request.getAttribute("isNotValid")) { %>
    <h6 style="color:red;" >Invalid User data</h6>
  	<% } %>
    <form action="SignupServlet" method="POST">
      <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
      </div>
      <div class="form-group">
        <label for="gmail">Gmail:</label>
        <input type="email" id="gmail" name="gmail" required>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
      </div>
      <div class="form-group">
        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" name="phone" required>
      </div>
      <div class="form-group">
        <input type="submit" value="Sign Up">
      </div>
    </form>
  </div>
</body>
</html>
