/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets.db;
import java.sql.*;
/**
 *
 * @author Vineeth
 */
public class Dao {
    static String URL="jdbc:mysql://sql12.freemysqlhosting.net/sql12303678";
    static String uname="sql12303678";
    static String pass="sQUPTCCLHd";
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL,uname,pass);
        return con;
    }
    
}
