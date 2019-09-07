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
        <title>VCloud</title>
    </head>
    <nav>
            <div class="image"><img class="image1" src="img/vcloud.png"></div>
                <ul>
                    <li><a href="home.jsp">Upload</a></li>
                    <li><a href="list.jsp">Manage</a></li>
                    <li><a href="">About us</a></li>
                    <li><a class="logout_btn_1" href="LogoutServlet">Logout</a></li>
                </ul>
            </nav>
    <body>
        <%
    if(session.getAttribute("uname")==null)
        response.sendRedirect("index.jsp");
    else{
    %>
        <%!
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            %>
            <%
                response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
                response.addHeader("Pragma", "no-cache"); 
                response.addDateHeader ("Expires", 0);
                
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
                    if(dbmail.equals(email)){
                    %>
                    <tr>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getTimestamp(4)%></td>
                        <td><a href="FileDownloadServlet?fileName=<%=rs.getString(2)%>">Download</a></td>
                    </tr>
                    <% 
                    }
                }
}
                   %>
                   </tbody>
            </table>
            </center>
    </body>
</html>
