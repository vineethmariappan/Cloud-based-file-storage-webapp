/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vineeth
 */
@WebServlet(name = "FileDownloadServlet", urlPatterns = {"/FileDownloadServlet"})
public class FileDownloadServlet extends HttpServlet {

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
    public static int BUFFER_SIZE=1024*100;
    public static final String UPLOAD_DIR="resoures";
    public static String fileName=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        fileName=request.getParameter("fileName");
        if(fileName==null || fileName.equals("")){
             response.setContentType("text/html");
            response.getWriter().println("<h3>File" + fileName +"not found");
        }
        else{
            String applicationPath=getServletContext().getRealPath("");
            String downloadPath=applicationPath +File.separator + UPLOAD_DIR;
            String filePath=downloadPath+ File.separator +fileName;
            System.out.println(fileName);
            System.out.println(filePath);
            System.out.println("fileName"+ fileName);
            System.out.println("filePath:"+filePath);
            File file=new File(filePath);
            OutputStream outStream=null;
            FileInputStream inputStream = null;
            if(file.exists()){
                String mimeType="application/octet-stream";
                response.setContentType(mimeType);
                String headerKey="Content-Disposition";
                String headerValue=String.format("attachment; filename=\"%s\" ", file.getName());
               response.setHeader(headerKey, headerValue);
            try{
                outStream=response.getOutputStream();
                inputStream=new FileInputStream(file);
                byte[] buffer= new byte[BUFFER_SIZE];
                int bytesRead=-1;
                while((bytesRead=inputStream.read(buffer)) != -1){
                outStream.write(buffer, 0, bytesRead);
                }
                outStream.flush();
                if(outStream!=null){
                   outStream.close();
                }
            }
                catch(Exception e){
                      System.out.println(e);
                       
                        }
                 
    }
            else{
                
                response.setContentType("text/html");
                    response.getWriter().println("<h3>File "+ fileName +"is not found</h3>");
                }
        }
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
