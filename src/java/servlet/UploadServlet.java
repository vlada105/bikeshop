/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

/**
 *
 * @author Aleksandra
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
public class UploadServlet extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 150 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            // Check that we have a file upload request
            isMultipart = ServletFileUpload.isMultipartContent(request);
            response.setContentType("text/html");
    

            System.out.println("filePath + " + filePath);
            String servletPath = getServletContext().getRealPath("/");
            servletPath = servletPath.substring(0, servletPath.lastIndexOf("\\"));
            servletPath = servletPath.substring(0, servletPath.lastIndexOf("\\"));

            servletPath = servletPath.substring(0, servletPath.lastIndexOf("\\"));
            servletPath += "\\web\\slike\\";
            filePath = servletPath;
            //PathClass.img_path = filePath;

            if (!isMultipart) {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>No file uploaded</p>");
                out.println("</body>");
                out.println("</html>");
                return;
            }

            DiskFileItemFactory factory = new DiskFileItemFactory();

            // maximum size that will be stored in memory
            factory.setSizeThreshold(maxMemSize);

            // Location to save data that is larger than maxMemSize.
            factory.setRepository(new File(filePath));

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // maximum file size to be uploaded.
            upload.setSizeMax(maxFileSize);

            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");

            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                String fieldName = fi.getFieldName();
                System.out.println("fieldName = " + fieldName);

                System.out.println("----------");
                if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    String fileName = fi.getName();
                    System.out.println("fileName = " + fileName);

                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    fi.write(file);
                    out.println("Uploaded Filename: " + fileName + "<br>");
                } else {
                    String vrednost = fi.getString();
                    System.out.println("vrednost = " + vrednost);
                }
            }
            
            response.sendRedirect("admin.jsp");
            
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
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
