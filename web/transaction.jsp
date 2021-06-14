

<%@page import="model.Payment"%>
<%@page import="database.Upiti"%>
<%@page import="model.User"%>
<%@page import="model.Item"%>
<%@page import="model.Frame"%>
<%@page import="model.Brand"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String usernamex ="";
    try {
        Object u = request.getSession().getAttribute("username");
        usernamex = u.toString();
    } catch (Exception e) {
    }
    if (usernamex.equals("")) {
        response.sendRedirect("login.jsp");
    }
    
     User usr = Upiti.getUserByUsername(usernamex);
     
     int id = usr.getId();
     
     List<Payment> pmnts = Upiti.getPaymentsForUserID(id);
        

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
                    
                    <h4> ORDERS TO BE PAYED  </h4>
                   
                   <hr>
                    
                   <% for (int i = 0; i < pmnts.size(); i++) {%>
                    
                   <p> Name :  <%=pmnts.get(i).getItems().get(0).getName() %>   ===  
                       
                       Price : <%=pmnts.get(i).getItems().get(0).getPrice() %>  ===
                   
                       Order ID : <%=pmnts.get(i).getId() %>                    
                   </p>
                   
                   <hr>                               
                      
                   <% }%>

                                       
                        

                </div>
                    
                <%@include file="aside.jsp" %>



                <div class="clear"></div>

            </div>






            <%@include file="footer.jsp" %> 
        </div>

    </body>
</html>
