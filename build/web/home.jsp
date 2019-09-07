<%-- 
    Document   : home
    Created on : Aug 31, 2019, 9:46:28 PM
    Author     : Vineeth
--%>

<%@page import="java.sql.*"%>
<%@page import="com.servlets.db.Dao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet_home.css">
       <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
        <title>VCloud</title>
    </head>
    <%
    if(session.getAttribute("uname")==null)
        response.sendRedirect("index.jsp");
    %>
     <%
        response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
        response.addHeader("Pragma", "no-cache"); 
        response.addDateHeader ("Expires", 0);
      %>
       <body> 
           <nav>
           <link rel="icon" href="favicon.png" type="img/vcloud.png"/>
                    <div class="image"><img class="image1" src="img/vcloud.png"></div>
                <ul>
                    <li><a href="home.jsp">Upload</a></li>
                    <li><a href="list.jsp">Manage</a></li>
                    <li><a href="">About us</a></li>
                    <li><a href="LogoutServlet">Logout</a></li>
                </ul>
               
            </nav>
            
          
            <div class="container">
                <form action="FileUploadServlet" method="post" enctype="multipart/form-data">
                    <center>
                        <p class="choose">Choose a file to upload</p><br><br>
                        <input type="file" name="file"><br><br>
                <input class="upload_btn" type="submit" value="Upload">
                </center>
            </form>
            </div>
    </body>
</html>
