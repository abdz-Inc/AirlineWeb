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

