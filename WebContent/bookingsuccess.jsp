<%@ page import="backend.*" %>
<!DOCTYPE html>
<html>
<head>
  <title>Ticket Information</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }

    .container {
      margin: 20px auto;
      width: 300px;
    }

    h1 {
      text-align: center;
    }

    .ticket-info {
      margin-top: 20px;
    }

    .ticket-info p {
      margin-bottom: 10px;
    }

    .links {
      margin-top: 20px;
      text-align: center;
    }

    .links a {
      display: inline-block;
      margin-right: 10px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>Ticket Information</h1>
    <div class="ticket-info">
      <p>Ticket ID: <%= request.getAttribute("tid") %></p>
      <p>Passenger Name: <%= request.getAttribute("name") %></p>
      <p>Booking Id: <%= request.getAttribute("bid") %></p>
      <p>Amount: <%= request.getAttribute("amount") %></p>
    </div>
    <div class="links">
    <form method="get" action="Logout"></form>
      <input type = "submit" value="Logout">
      </form>
      <a href="mainpage.jsp">Search</a>
    </div>
  </div>
</body>
</html>
