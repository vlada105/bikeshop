<%@page import="model.Item"%>
<%@page import="model.Frame"%>
<%@page import="model.Brand"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% 
    int id = Integer.parseInt(request.getParameter("id"));
    
    List<Item> branditems = Upiti.getItemsForBrandID(id);
    
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
                        
                        
                            
                        <% for (int i = 0; i < branditems.size(); i++) {%>
                        <a href ="item.jsp?id=<%=branditems.get(i).getId()%>"> <li>
                                
                                <img src="slike/<%=branditems.get(i).getName()%>.jpg"  alt="<%=branditems.get(i).getName()%>" >
                                
                                
                                <p> <%=branditems.get(i).getName()%> </p> 
                                
                                <p> Price: <%=branditems.get(i).getPrice()%></p> 
                                
                                <p> Click For Details </p>
                                        
                                                               
                        </li> </a>
                        <% }%>
                    
                    </ul>
                    
                    
                </div>
                
                                
                <%@include file="aside.jsp" %>               
                                
                                
                
                
                <div class="clear"></div>
                
            </div>
            
           
            
        </div>
        
    </body>
</html>
