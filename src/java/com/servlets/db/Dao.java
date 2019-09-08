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
    static String URL="jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12304436";
    static String uname="sql12304436";
    static String pass="Ah6kER71S1";
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL,uname,pass);
        return con;
    }
    
}
