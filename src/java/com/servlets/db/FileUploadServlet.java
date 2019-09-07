/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets.db;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Vineeth
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/FileUploadServlet"})
@MultipartConfig(fileSizeThreshold=1024*1024*10,maxFileSize=1024*1024*1000,maxRequestSize=1024*1024*1000)
public class FileUploadServlet extends HttpServlet {
    PrintWriter out=null;
    Connection con=null;
    PreparedStatement ps=null;
    HttpSession session=null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<br><br><br>");
            out.println("<a style=\"text-decoration:none;    font-size: 40px;color:blue;\" href=\"list.jsp\">View your files</a><br>");
            out.println("<a style=\"text-decoration:none;    font-size: 40px;color:blue;\" href=\"home.jsp\">Click here to upload more files</a>");
            out.println("<title>File</title>"); 
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            
            

        }
       
     
    }
    
       
       
        

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        session=request.getSession(false);
   
        String folderName="resoures";
        String uploadPath=request.getServletContext().getRealPath("") + File.separator +folderName;
        String email=(String) session.getAttribute("uname");
        File dir=new File(uploadPath);
        if(!dir.exists())
                dir.mkdirs();
        Part filePart = request.getPart("file");
        String fileName=filePart.getSubmittedFileName();
        String path = folderName + File.separator + fileName;
        Timestamp added_date= new Timestamp(System.currentTimeMillis());
        System.out.println("filename : " +fileName);
        System.out.println("Path:" +uploadPath);
        InputStream is=filePart.getInputStream();
        Files.copy(is,Paths.get(uploadPath+File.separator + fileName),StandardCopyOption.REPLACE_EXISTING);
        
        try {
               
            Connection con_3=Dao.getConnection();
            String query="insert into DataFiles(email,filename,path,added_data) values (?,?,?,?)";
            ps=con_3.prepareStatement(query);
            ps.setString(1,email);
            ps.setString(2, fileName);
            ps.setString(3,path);
            ps.setTimestamp(4, added_date);
            int count=ps.executeUpdate();
            if(count>0){
                session.setAttribute("filename",fileName);
                response.sendRedirect("list.jsp");
               
                 //   System.out.println("File Uploaded successfully");
                 // System.out.println("Upload path"+ uploadPath);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       
    }
    
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
