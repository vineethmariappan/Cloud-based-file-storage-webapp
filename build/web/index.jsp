<%-- 
    Document   : index
    Created on : Aug 31, 2019, 6:15:08 PM
    Author     : Vineeth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VCloud</title>
         <link rel="stylesheet" href="stylesheet_login.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
    </head>
    <body>
        <div class="top_page">
            
            
        </div>
        <div class="box-2">
            <img class="logo" src="img/vcloud.png">
            <p>Vineeth Creations</p>
            <div class="line"></div>
            <p class="sign">Free Cloud<br>Storage for you.</p>
            
              <a class="btn1" href="register.jsp">New here? click here to register</a>
            
        </div>
       
         <div class="box">
            <h2>Welcome</h2>
            <h5>Login to get Started!</h5>
        <form action="LoginDao" method="post">  
             <div class="inputBox">
            <input id="email_1" type="text" name="Email">
            <label>Email</label>
             </div>
             <div class="inputBox">
            <input id="password1" type="password" name="Password">
            <label>Password</label>
             </div>
             <div>
            <input type="submit" value="Login">
             </div>
            
        </form>
 </div>
           
    </body>
</html>
