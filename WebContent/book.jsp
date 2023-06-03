<!DOCTYPE html>
<html>
<head>
  <title>Seat Booking</title>
  <style>
  body {
      background: linear-gradient(to right, #4e54c8, #002D62);
      font-family: Arial, sans-serif;
    }
    body {
      font-family: Arial, sans-serif;
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
    .form-group input {
      width: 100%;
      padding: 5px;
      border: 1px solid #ccc;
      border-radius: 3px;
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
    .container {
      margin: 20px auto;
      width: 300px;
    }

    h1 {
      text-align: center;
    }

    .form-group {
      margin-bottom: 10px;
    }

    .form-group label {
      display: block;
      margin-bottom: 5px;
    }

    .form-group input[type="number"] {
      width: 100%;
      padding: 5px;
    }

    .booking-info {
      text-align: center;
      margin-top: 20px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>Seat Booking</h1>
    <form method="post" action="ConfirmBooking">
    <div class="form-group">
    	
      <label for="seats">Number of Seats:</label>
      <input type="number" name = "seats" id="seats" min="1" max="10" required>
      </div>
      <button type="submit" class="btn">Proceed</button>
    
    
    <div class="form-group">
    	<label for "tripid">TripId :</label><input type="text" name="tripid" value=<%= request.getAttribute("tripid") %> readonly required>
		</div>
		<div class="form-group">
		<label for "userid">UserId :</label><input type="text" name="userid" value=<%= request.getAttribute("userid") %> readonly required>
		</div>
    </div>
    </form>
  </div>
	
</body>
</html>
