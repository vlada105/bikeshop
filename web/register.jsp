

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUY A BIKE REGISTER PAGE</title>
        <link  href="css/styles.css" rel="stylesheet" >
    </head>
    <body>
        <div id="container">
            
            <%@include file="header.jsp" %>
            
            <div id="content">
                
                <div id="products">

                    <h1>REGISTRATION FORM</h1>
                    <form method="POST" action="RegistrationServlet">
                        USERNAME: <input  type="text" name="username"> <br>
                        PASSWORD: <input  type="text" name="password"> <br> 
                        FIRST NAME: <input  type="text" name="firstname"> <br> 
                        LAST NAME:  <input  type="text" name="lastname"> <br>
                        ADDRESS: <input  type="text" name="address"> <br>
                        PHONE NUMBER: <input type="number" name="phonenumber"  placeholder="0601234567"> <br>
                        EMAIL ADDRESS: <input type="email" name="email"> <br>
                        
                        <input  type="submit" name="submit" value="REGISTER"> <br>  
                    </form>

                    
                </div>
                
                <%@include file="aside.jsp" %>
                
                <div class="clear"></div>
                
            </div>
            
                
                
            
        
        
           <%@include file="footer.jsp" %> 
        </div>
        
    </body>
</html>
