<!DOCTYPE html>
<html>
<head>
  <title>Admin Page</title>
  <style>
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
    .form-group input[type="number"],
    .form-group input[type="date"] {
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
    .logout-button {
      position: absolute;
      top: 20px;
      right: 20px;
    }
    .add-admin-button {
      position: absolute;
      top: 20px;
      right: 80px;
    }
  </style>
</head>
<body>
<form action = "Logout" method="get">
<button class = "logout-button">logout</button>
</form>
<form action = "adminsignup.jsp" method="post">
<button class = "add-admin-button">add admin</button>
</form>

  <div class="container">
  	
    <h1>Add Flight</h1>
    <% if ( request.getAttribute("addFlight") != null && (boolean) request.getAttribute("addFlight")) { %>
    <h6 style="color:green;" >Flight added successfully </h6>
  	<% } else if( request.getAttribute("addFlight") != null && (boolean) request.getAttribute("addFlight") == false ) {%>
		<h6 style="color:red;" > Flight not added </h6>
	<% } %>
    <form action="FlightServlet" method="POST">
      <div class="form-group">
        <label for="flightno">Flight No:</label>
        <input type="number" id="flightno" name="flightno" required>
      </div>
      <div class="form-group">
        <label for="flightname">Flight Name:</label>
        <input type="text" id="flightname" name="flightname" required>
      </div>
      <div class="form-group">
        <label for="seats">No. of seats:</label>
        <input type="number" id="seats" name="seats" required>
      </div>
      <div class="form-group">
        <input type="submit" value="Add Flight">
      </div>
    </form>
 	</div>
 	<div class="container">
    <h1>Add Trip</h1>
    <% if ( request.getAttribute("addTrip") != null && (boolean) request.getAttribute("addTrip")) { %>
    <h6 style="color:green;" >Trip added successfully </h6>
  	<% } else if( request.getAttribute("addTrip") != null && (boolean) request.getAttribute("addTrip") == false ) {%>
		<h6 style="color:red;" > Trip not added </h6>
	<% } %>
    <form action="TripServlet" method="POST">
      <div class="form-group">
        <label for="tripNtripnoame">Trip No:</label>
        <input type="number" id="tripno" name="tripno" required>
      </div>
      <div class="form-group">
        <label for="flightno">Flight No:</label>
        <input type="number" id="flightno" name="flightno" required>
      </div>
      <div class="form-group">
        <label for="source">Source:</label>
        <input type="text" id="source" name="source" required>
      </div>
      <div class="form-group">
        <label for="destination">Destination:</label>
        <input type="text" id="destination" name="destination" required>
      </div>
      <div class="form-group">
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required>
      </div>
      <div class="form-group">
        <label for="time">Time:</label>
        <input type="time" id="time" name="time" required>
      </div>
      <div class="form-group">
        <label for="cost">Cost per seat:</label>
        <input type="number" id="cost" name="cost" required>
      </div>
      <div class="form-group">
        <input type="submit" value="Add Trip">
      </div>
    </form>
  </div>
</body>
</html>
