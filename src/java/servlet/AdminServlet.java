/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import database.Upiti;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Brand;
import model.Category;
import model.Frame;
import model.Item;

/**
 *
 * @author VLADA
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

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
            String action = request.getParameter("action");
            
            if(action.equals("ADD-BRAND")){
               String name = request.getParameter("name");
               

               Brand noviBrand = new Brand(name);
               Upiti.addBrand(noviBrand);
               response.sendRedirect("admin.jsp");
           }
            
           if(action.equals("ADD-CATEGORY")){
               String name = request.getParameter("name");
               

               Category novaCategory = new Category(name);
               Upiti.addCategory(novaCategory);
               response.sendRedirect("admin.jsp");
           }
           
           if(action.equals("ADD-FRAME")){
               String name = request.getParameter("name");
               

               Frame noviFrame = new Frame(name);
               Upiti.addFrame(noviFrame);
               response.sendRedirect("admin.jsp");
           }
           
           
           if(action.equals("DELETE-BRAND")){
               String brand = request.getParameter("brand");
               int brand_id = Integer.parseInt(brand);             
               Brand b = new Brand();
               b.setId(brand_id);  
               Upiti.deleteBrand(b);        
               response.sendRedirect("admin.jsp");
           
           }
           
           
           if(action.equals("DELETE-CATEGORY")){
               String category = request.getParameter("category");
               int category_id = Integer.parseInt(category);             
               Category c = new Category();
               c.setId(category_id);  
               Upiti.deleteCategory(c);        
               response.sendRedirect("admin.jsp");
           
           }
           
           if(action.equals("DELETE-FRAME")){
               String frame = request.getParameter("frame");
               int frame_id = Integer.parseInt(frame);             
               Frame f = new Frame();
               f.setId(frame_id);  
               Upiti.deleteFrame(f);        
               response.sendRedirect("admin.jsp");
           
           }
           
           if(action.equals("ADD-ITEM")){
               String name = request.getParameter("name");
               double price = Double.parseDouble(request.getParameter("price"));
               String description = request.getParameter("description");
               int quantity = Integer.parseInt(request.getParameter("quantity"));
               String img = request.getParameter("img");
               int brand_id = Integer.parseInt(request.getParameter("brand"));
               int category_id = Integer.parseInt(request.getParameter("category"));
               int frame_id = Integer.parseInt(request.getParameter("frame"));

               
               Brand b= Upiti.getBrandByID(brand_id);
               
               Category c = Upiti.getCategoryByID(category_id);
               
               Frame f = Upiti.getFrameByID(frame_id);
               
               
               Item noviItem = new Item(name, price, description, quantity, img, b, c, f);
               
                                 
               
               Upiti.addItem(noviItem);
                       
                       
               response.sendRedirect("admin.jsp");
           }
           
           if(action.equals("DELETE-ITEM")){
               String item = request.getParameter("item");
               int item_id = Integer.parseInt(item);             
               Item i = new Item();
               i.setId(item_id);  
               Upiti.deleteItem(i);
               response.sendRedirect("admin.jsp");
           
           }
           
           
           if(action.equals("FINISH-ORDER")){
               String order_id = request.getParameter("order_id");
               
                try {
                    Upiti.deleteOrderByID(order_id);
                    response.sendRedirect("admin.jsp");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
                    response.sendRedirect("adminerror.jsp");
                }
                            
              
           
           }
           
           
           
           
           
            
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
