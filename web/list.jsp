<%-- 
    Document   : list
    Created on : Sep 1, 2019, 7:18:22 PM
    Author     : Vineeth
--%>

<%@page import="com.servlets.db.Dao"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="stylesheet_list.css">
        <title>OnlineDrive</title>
    </head>
    <nav>
            <div class="image"><img class="image1" src="img/Simple-Force-Logo.png"></div>
                <ul>
                    <li><a href="">Upload</a></li>
                    <li><a href="">Manage</a></li>
                    <li><a href="">About us</a></li>
                </ul>
            </nav>
    <body>
        <%!
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            %>
    <center>
            <table border="2">
                <thead>
                <tr>
                    <th>Filename</th><th>Date Uploaded</th><th>Download</th>
                </tr>
                </thead>
                <tbody>
                <%
                    con=Dao.getConnection();
                    String query="select * from DataFiles";
                    ps=con.prepareStatement(query);
                    rs =ps.executeQuery();
                    while(rs.next()){
                        String email=rs.getString(1);
                        String dbmail=(String)request.getSession().getAttribute("uname");
                        System.out.println(dbmail + "----" + email);
                    if(email.equals(dbmail)){
                    %>
                    <tr>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getTimestamp(4)%></td>
                        <td><a href="FileDownloadServlet?fileName=<%=rs.getString(2)%>">Download</a></td>
                    </tr>
                    <% 
                    }
                }
                      
                   %>
                   </tbody>
            </table>
            </center>
    </body>
</html>
