<%-- 
    Document   : register
    Created on : Aug 31, 2019, 6:49:55 PM
    Author     : Vineeth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="stylesheet_register.css">
          <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
    <center>
        <div class="container">
        <h1>Registration Form</h1>
        <form action="RegisterServlet" method="post">  
            <label class="lbl">Email</label>
            <input class="field_1" type="text" name="Email"><br>
             <label class="lbl_1">Password</label>
             <input class="field_2"type="password" name="Password"/><br>
            <input class="btns"type="submit" value="Register">
        </form>
        </div>
        </center>
    </body>
</html>
