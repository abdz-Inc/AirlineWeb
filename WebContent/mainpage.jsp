<%@ page import="java.util.ArrayList" %>
<%@ page import="backend.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  <title>Airplane Reservation</title>
  <style>
  body {
      background: linear-gradient(to right, #4e54c8, #002D62);
      font-family: Arial, sans-serif;
    }
    body {
      font-family: Arial, sans-serif;
    }
    table {
      border-collapse: collapse;
      width: 100%;
    }
    
    th, td {
      border: 1px solid #ccc;
      padding: 8px;
      text-align: left;
    }
    .container {
      width: 600px;
      margin: 0 auto;
      margin-top: 50px;
      background-color: #f2f2f2;
      border-radius: 5px;
      padding: 20px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    
    h2 {
      text-align: center;
      margin-bottom: 20px;
    }
    
    .form-group {
      margin-bottom: 20px;
    }
    
    .form-group label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }
    
    .form-group input[type="text"],
    .form-group input[type="date"],
    .form-group input[type="time"] {
      width: 100%;
      padding: 5px;
      border: 1px solid #ccc;
      border-radius: 3px;
    }
    
    .btn-search {
      width: 100%;
      background-color: #4CAF50;
      color: #fff;
      border: none;
      padding: 10px;
      font-size: 16px;
      cursor: pointer;
      border-radius: 3px;
    }
    
    .btn-search:hover {
      background-color: #45a049;
    }
    
    .link {
      text-align: center;
      margin-top: 10px;
    }
    .logout-button {
      position: absolute;
      top: 20px;
      right: 20px;
    }
  </style>
</head>
<body>
<form action = "Logout" method="get">
<button class = "logout-button">logout</button>
</form>
  <div class="container">
    <h2>Airplane Reservation</h2>
    <form action="SearchServlet" method="post">
      <div class="form-group">
        <label for="source">Source:</label>
        <input type="text" id="source" name="source" >
      </div>
      <div class="form-group">
        <label for="destination">Destination:</label>
        <input type="text" id="destination" name="destination" >
      </div>
      <div class="form-group">
        <label for="date">Date(YYYY-MM-DD): *required </label>
        <input type="date" id="date" name="date" pattern="(2[0-9][0-9][0-9])-(0[1-9]|1[1-2])-(0[1-9]|1[0-9]|2[0-9]|3[0-1])" required>
      </div>
      <div class="form-group">
        <label for="time">Time (24-hour Format):</label>
        <input type="time" id="time" name="time" pattern="(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]" >
      </div>
      <button type="submit" class="btn-search">Search</button>
    </form>
    <br>
    <br>
    <form method="get" action="BookingHistoryServlet">
      <button type="submit" class = "btn-search">View Bookings</button>
    </form>
    <br>
    <br>
    <% if ( request.getAttribute("nullTripid") != null  && ((boolean) request.getAttribute("nullTripid")) == true) { %>
    	<h5 style="COLOR:RED;"> Trip details invalid </h5>
	<% } %>
    <% if ( request.getAttribute("hasSearched") != null  && ((boolean) request.getAttribute("hasSearched")) == true) { %>
    	<% if ((boolean) request.getAttribute("hasNoResult")) { %>
    		<h6 style="color:red;" >--No Flights Found--</h6>
    	<% } else { %>
    		<table>
    		<thead>
		      <tr>
		        <th>Trip no.</th>
		        <th>Flight no.</th>
		        <th>Source</th>
		        <th>Destination</th>
		        <th>Date</th>
		        <th>Time</th>
		        <th>Cost</th>
		        <th>BookTicket</th>
		      </tr>
		    </thead>
		    <tbody>
		    <form method = "post" action = "BookServlet">
    		<%
    			int i = 0;
    			while (i < ((ArrayList<Trip>) request.getAttribute("trips")).size()) {
  			%>
      			<tr>
      				<td> <%= ((Trip) ((ArrayList<Trip>) request.getAttribute("trips")).get(i)).getTripid() %></td>
      				<td> <%= ((Flight) ((Trip) ((ArrayList<Trip>) request.getAttribute("trips")).get(i)).getFlight()).getFlightno() %></td>
      				<td> <%= ((Trip) ((ArrayList<Trip>) request.getAttribute("trips")).get(i)).getSrc() %></td>
      				<td> <%= ((Trip) ((ArrayList<Trip>) request.getAttribute("trips")).get(i)).getDest() %></td>
      				<td> <%= ((Trip) ((ArrayList<Trip>) request.getAttribute("trips")).get(i)).getDate() %></td>
      				<td> <%= ((Trip) ((ArrayList<Trip>) request.getAttribute("trips")).get(i)).getTime() %></td>
      				<td> <%= ((Trip) ((ArrayList<Trip>) request.getAttribute("trips")).get(i)).getCostperseat() %></td>
      				<td> <button class = "button" name = "button" type = "submit"  value = <%= ((Trip) ((ArrayList<Trip>) request.getAttribute("trips")).get(i)).getTripid() %> >book</button>
      			</tr>
  			<%
      			i++;
    			}
  			%>
  			</form>
  			</tbody>
  			</table>
  		<% } %>
  	<% } %>
  	<% if ( request.getAttribute("hasBookings") != null  && ((boolean) request.getAttribute("hasBookings")) == true) { %>
    	<% if ((boolean) request.getAttribute("hasNoBookings")) { %>
    		<h6 style="color:red;" >--No Bookings Found--</h6>
    	<% } else { %>
    		<table>
    		<thead>
		      <tr>
		        <th>Trip no.</th>
		        <th>amount</th>
		        <th>No. of Tickets</th>
		      </tr>
		    </thead>
		    <tbody>
		    
    		<%
    			int i = 0;
    			while (i < ((ArrayList<BookTicket>) request.getAttribute("bookings")).size()) {
  			%>
      			<tr>
      				<td> <%= ((BookTicket) ((ArrayList<BookTicket>) request.getAttribute("bookings")).get(i)).getTripid() %></td>
      				<td> <%= ((BookTicket) ((ArrayList<BookTicket>) request.getAttribute("bookings")).get(i)).getAmount() %></td>
      				<td> <%= ((BookTicket) ((ArrayList<BookTicket>) request.getAttribute("bookings")).get(i)).getNoofseats() %></td>
      			</tr>
  			<%
      			i++;
    			}
  			%>
  			</tbody>
  			</table>
  		<% } %>
  	<% } %>
  </div>
</body>
</html>
