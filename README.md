# AirlineWeb

A flight ticket reservation system with a basic GUI to experiment the working of backend.<br>
Java web development technologies (jsp, servlet, jdbc, etc.,) used for implementation of backend.<br>
MySQL is used as the database, hosted in cloud database provider PlanetScale.<br>

#Implementation

AirlineWeb contains two main parts the backend pakage and GUI.<br>
These packages work together to give a full-stack experience to the user<br>
The whole system consist of five classes that have their own individual functionality.<br>
All classes are encapsulated to prevent data corruption and ensure integrity.<br>
The five elementary classes are:-
<ul>
<li>User</li>
<li>Admin</li>
<li>Flight</li>
<li>Trip</li>
<li>BookTicket</li>
</ul>

#User

The user class represents the attributes and functionalities of the user which includes name, password, email etc.,<br>
and login, signup etc., Every user has an unique id. Login is done using email and password. Anyone can create a new <br>
user by providing fields for user class through signup functionality. Userinfo table is used to store the information of the<br>
user.

#Admin

The Admin class represents the administrator who has the ability to modify the system, like adding flights, creating<br>
new trips etc., A new admin can only be created by an existing admin. Every admin has an unique id and login is based on email<br>
and password. Admininfo table is used to store the information of admin. Important admin unctionalities include:
<ul>
  <li>addFlight</li>
  <li>addTrip</li>
  <li>addAdmin</li>
 </ul>
 
#Flight

The Flight class is used to represent a single flight object and its state like, flight number, flight name and number of seats<br>
Flight information is stored in the flight table. It has functionalities to retrieve flight object based on flightno as it is an unique attribute<br>
getFlight. Only an admin can create a flight object.

#Trip

The Trip class represent one trip or a single journey, where it binds one flight on a given date and time slot on a source to destination.<br>
It stores the attributes tripid, source, destination, date, time, flight and cost for a particular trip. A trip can only be created by admin.<br>
A trip object can be retrieved using the getTrip functionality which returns list of all trips that match the given configuration.<br>
Also it has the functionality to display the no of seats available in the particular Flight for the particular Trip.

#BookTicket

The BookTicket class represents the booking of a Trip, by a User and the amount. This information is stored in the book table.<br>
Booking can be done by a User object using the bookTicket functionality. The BookTicket class also gives user the functionality to retrieve<br>
their booking history.

#Front-End

Html, css are used to create a basic frontend. A dynamic web project is initialize in the eclipse platform to<br>
handle the java web configurations

![image](https://github.com/abdz-Inc/AirlineWeb/assets/69815749/466d834a-0579-4346-8b37-b51af5eeb1df)


#Servlets

Servlets are used to connect the user input with the class functionalities. The classes handle database connectivity<br>
and manipulation while the servlet make use of the classes to process user input. The various servlet classes<br>
form a bridge between the userinterface and data.

#Login and Signup Servlets

<ul>
  <li>LoginServlet</li>
  <li>SignupServlet</li>
  <li>AdminLoginServlet</li>
  <li>AdminSignupServlet</li>
  <li>Logout</li>
  </ul>
   These servlets are used to implement the user and admin, creation and verification functionality. They maintain a session where the user or admin objecta,br>
   is stored and used for authoriztion purposes. The logout servlet class flushes the session variables and redirects to login page.
   
#Search Servlet

The Search servlet gets the constarints from the user and invokes the getTrip functionality of Trip class to get a list of Trips which fall<br>
under the given constraint. This list is further sent to the page where it gets displayed.

#Book Servlet

The Book Servlet provides the information of the trip that the user has choosen to book and requests for no of seats the user wants to book<br>
It retrieves the trip information from the list of trips previously invoked.

#ConfirmBooking

Once the user enters the no of ticket the ConfirmBooking servlet is invoked whoich creates a booking object using the given information<br>
Also it updates the book table with information of user id, trip id, amount etc., In order to create a booking a user object is neccessary which<br>
is created only if logged in or signed up before reaching this page.

#BookingHistoryServlet

This servlet is used to retrieve all the bookings done by a aprticular user. Thus this server requires an user class and can show the booking history<br>
of that particular user to himself. It queries the book table in database to retrieve all booking done by a particular user.

#FlightServlet

Flight Servlet class perfor,s the functionality of creating a new flight object and updating the flight table in database<br>.
This functionality can only be done if an admin object is found, thus making an admin login must.

#TripServlet

Trip servlet is also used only by an admin to create a trip, where the required attributes are taken as input from <br>
the admin and the trip table is updated in the database. Only admin can perform this functionality as it checks for an admin object in session.
