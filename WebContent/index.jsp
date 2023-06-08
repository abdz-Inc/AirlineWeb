<html>
   <head>
      <title>Redirection</title>
   </head>
   
   <body>
      <%
         // New location to be redirected
         String site = new String("login.jsp");
         response.setStatus(response.SC_MOVED_TEMPORARILY);
         response.setHeader("Location", site); 
      %>
   </body>
</html>
