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
        <title>Home</title>
    </head>
       
       <body> 
           <nav>
                    <div class="image"><img class="image1" src="img/Simple-Force-Logo.png"></div>
                <ul>
                    <li><a href="">Upload</a></li>
                    <li><a href="">Manage</a></li>
                    <li><a href="">About us</a></li>
                </ul>
            </nav>
           <h1>Welcome to home page!</h1>
        <% 
            
            String email=request.getParameter("Email");
            String password=request.getParameter("Password");
            Connection con_2=Dao.getConnection();
            Statement st= con_2.createStatement();
            ResultSet rs =st.executeQuery("select * from profiles");
            int flag=0;
            String unamet,upasst;
            while(rs.next()){
                unamet=rs.getString(1);
                upasst=rs.getString(2);
              if(unamet.equals(email) && upasst.equals(password)){
                  flag=1;
                  request.setAttribute("uname",unamet);
                  request.setAttribute("upass",upasst);
            %>You are welcome<%
              }
            }
            if(flag==0)
               response.sendRedirect("index.jsp");

            %>
            <div class="upload_container">
                <form action="FileUploadServlet" method="post" enctype="multipart/form-data">
                <p>Choose the file that you want to upload</p>
                <input type="file" name="file">
                <input type="submit" value="upload">
            </form>
            </div>
    </body>
</html>
