


<%@page import="model.Item"%>
<%@page import="model.Frame"%>
<%@page import="model.Category"%>
<%@page import="database.Upiti"%>
<%@page import="java.util.List"%>
<%@page import="model.Brand"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!

    
    public static String convertListToSelect(List<Brand> listabrendova)
    {
        String html = "<SELECT NAME=\"brand\">";
        for(int i =0; i<listabrendova.size(); i++)
            html += "<option value='" + listabrendova.get(i).getId()+ "'> " + listabrendova.get(i).getName() + " </option>";
            html +="</select>";
        return html;
    }

    public static String convertCategoryListToSelect(List<Category> kategorije)
    {
        String html = "<SELECT NAME=\"category\">";
        for(int i =0; i<kategorije.size(); i++)
            html += "<option value='" + kategorije.get(i).getId()+ "'> " + kategorije.get(i).getName() + " </option>";
            html +="</select>";
        return html;
    }

    public static String convertFrameListToSelect(List<Frame> ramovi)
    {
        String html = "<SELECT NAME=\"frame\">";
        for(int i =0; i<ramovi.size(); i++)
            html += "<option value='" + ramovi.get(i).getId()+ "'> " + ramovi.get(i).getMaterial() + " </option>";
            html +="</select>";
        return html;
    }

    public static String convertItemListToSelect(List<Item> items)
    {
        String html = "<SELECT NAME=\"item\">";
        for(int i =0; i<items.size(); i++)
            html += "<option value='" + items.get(i).getId()+ "'> " + items.get(i).getName() + " </option>";
            html +="</select>";
        return html;
    }





%>


<%
    String username ="";
    try {
        Object u = request.getSession().getAttribute("username");
        username = u.toString();
    } catch (Exception e) {
    }
    if (!username.equals("admin")) {
        response.sendRedirect("forbidden.jsp");
    }
    

    List<Brand> listabrendova = Upiti.getAllBrands();
    List<Category> kategorije = Upiti.getAllCategories();
    List<Frame> ramovi = Upiti.getAllFrames();
    List<Item> proizvodi = Upiti.getAllItems();

%>



    

    





<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link  href="css/styles.css" rel="stylesheet" >
    </head>
     <body>
        <div id="container">
            
            <%@include file="header.jsp" %>
            
            <div id="content">
                
                <div id="products">
                    
                    <hr><hr>
                    
                    <H3> ADD NEW BRAND </H3>
                    <form method="POST" action="AdminServlet" >
                        NAME: <input  type="text" name="name"> <br>
                        
                              <input  type="submit" name="action"  value="ADD-BRAND"> <br>  
                    </form>
                    
                    
                    <hr>
                    
                    <hr>
                    
                    <H3> ADD NEW CATEGORY </H3>
                    <form method="POST" action="AdminServlet" >
                        NAME: <input  type="text" name="name"> <br>
                        
                              <input  type="submit" name="action"  value="ADD-CATEGORY"> <br>  
                    </form>
                    
                    
                    <hr>
                    
                    <hr>
                    
                    <H3> ADD NEW FRAME </H3>
                    <form method="POST" action="AdminServlet" >
                        NAME: <input  type="text" name="name"> <br>
                        
                              <input  type="submit" name="action"  value="ADD-FRAME"> <br>  
                    </form>
                    
                    
                    <hr>
                    
                    <hr>
                    
                    <H3> DELETE BRAND </H3>
                    <form method="POST" action="AdminServlet" >
                        
                        <%=convertListToSelect(listabrendova)%>
                        
                        <br>
                        
                        <input  type="submit" name="action"  value="DELETE-BRAND"> <br>  
                    </form> 
                    
                    <hr>
                    <hr>
                    
                    <H3> DELETE CATEGORY </H3>
                    <form method="POST" action="AdminServlet" >
                        
                        <%=convertCategoryListToSelect(kategorije)%>
                        
                        <br>
                        
                        <input  type="submit" name="action"  value="DELETE-CATEGORY"> <br>  
                    </form> 
                    
                    <hr>
                    <hr>
                    
                    <H3> DELETE FRAME </H3>
                    <form method="POST" action="AdminServlet" >
                        
                        <%=convertFrameListToSelect(ramovi)%>
                        
                        <br>
                        
                        <input  type="submit" name="action"  value="DELETE-FRAME"> <br>  
                    </form> 
                    
                    <hr>
                    <hr>
                    
                    <H3> ADD ITEM </H3>
                    <form method="POST" action="AdminServlet" >
                        
                        NAME: <input  type="text" name="name"> <br>
                        PRICE: <input type="number" name="price" min="0"> <br>
                        DESCRIPTION: <input  type="text" name="description"> <br>
                        QUANTITY: <input type="number" name="quantity" min="0"> <br>
                        IMG : <input  type="text" name="img"><br>
                        BRAND: <%=convertListToSelect(listabrendova)%> <br>
                        CATEGORY: <%=convertCategoryListToSelect(kategorije)%> <br>
                        FRAME : <%=convertFrameListToSelect(ramovi)%> 
                        
                        
                        <br>
                        
                        <input  type="submit" name="action"  value="ADD-ITEM"> <br>  
                    </form> 
                    
                    <hr>
                    <hr>
                    
                    <H3> DELETE ITEM </H3>
                    <form method="POST" action="AdminServlet" >
                        
                        <%=convertItemListToSelect(proizvodi) %>
                        
                        <br>
                        
                        <input  type="submit" name="action"  value="DELETE-ITEM"> <br>  
                    </form> 
                    
                    <hr>
                    <hr>
                    
                    
                    <form action = "UploadServlet" method = "post"  enctype = "multipart/form-data">
                        <input type = "file" name = "file" size = "50" /><br>
                        <input type="text" name="ime"/> <br>
                        <input type = "submit" value = "Upload File" />
                    </form>
                    
                    <hr>
                    <hr>
                    <hr>
                    <hr>
                    <hr>
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    <H3> FINISH PAYED ORDERS </H3>
                    <form method="POST" action="AdminServlet" >
                        
                        
                        ORDER ID: <input  type="number" name="order_id">   <br>
                        
                       
                        
                        <input  type="submit" name="action"  value="FINISH-ORDER"> <br>  
                    </form> 
                    
                    <hr>
                    <hr>
                    
                    
                    
                    
                    
                    
                </div>
                
                <%@include file="aside.jsp" %>
                
                <div class="clear"></div>
                
            </div>
            
                
                
            
        
        
           <%@include file="footer.jsp" %> 
        </div>
        
    </body>
</html>
