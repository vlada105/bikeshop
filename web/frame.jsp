
<%@page import="database.Upiti"%>
<%@page import="model.Item"%>
<%@page import="model.Frame"%>
<%@page import="model.Brand"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% 

    int id = Integer.parseInt(request.getParameter("id"));
    
    List<Item> frameitems = Upiti.getItemsForFrameID(id);
    
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
                    
                    <ul>
                        
                        
                            
                        <% for (int i = 0; i < frameitems.size(); i++) {%>
                        <a href ="item.jsp?id=<%=frameitems.get(i).getId()%>"> <li>
                                
                                <img src="slike/<%=frameitems.get(i).getName()%>.jpg"  alt="<%=frameitems.get(i).getName()%>" >
                                
                                
                                <p> <%=frameitems.get(i).getName()%> </p> 
                                
                                <p> Price: <%=frameitems.get(i).getPrice()%></p> 
                                
                                <p> Click For Details </p>
                                        
                                                               
                        </li> </a>
                        <% }%>    
                            
                            
                       
                                            
                    </ul>
                
                </div>
                         
                <%@include file="aside.jsp" %>
                
                
                
                <div class="clear"></div>
                
            </div>
                    
            <%@include file="footer.jsp" %>
            
        </div>
        
    </body>
</html>
