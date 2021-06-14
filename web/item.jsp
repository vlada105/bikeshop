<%@page import="model.Item"%>
<%@page import="model.Frame"%>
<%@page import="model.Brand"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% 
    int id = Integer.parseInt(request.getParameter("id"));
    
    Item itemx = Upiti.getItemByID(id); 
    
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BIKE SHOP BUY A BIKE</title>
        <link  href="css/styles.css" rel="stylesheet" >
    </head>
    <body>
        <div id="container">
            
            <%@include file="header.jsp" %>
            
            <div id="content">
                
                <div id="products">
                    
                    <div id="shopdiv" >
                        
                        <img src="slike/<%=itemx.getName()%>.jpg"  alt="<%=itemx.getName()%>" > <br>
                        
                        <p> <%=itemx.getName()%>  Description:   <%=itemx.getDescription() %> 
                            Price : <%=itemx.getPrice()%>     </p> 
                        
                        <form method="POST"   id="buyform"  action="PaymentServlet">
                            <input type="hidden" name="id"  value="<%=itemx.getId() %>"><br> 

                            <input type="hidden" name="username"  value="<%=username1%>"><br>

                            <input  type="submit" name="action" id="buybtn" value="BUY ITEM"><br> 
                        </form>
                       
                    </div>
                    
                </div>
                      
                <%@include file="aside.jsp" %>               
                                
                
                <div class="clear"></div>
                
            </div>
           
        </div>
        
    </body>
</html>
