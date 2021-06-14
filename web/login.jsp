

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BUY A BIKE LOGIN PAGE</title>
        <link  href="css/styles.css" rel="stylesheet" >
    </head>
    <body>
        <div id="container">
            
            <%@include file="header.jsp" %>
            
            <div id="content">
                
                <div id="products">

                    <h1>LOGIN FORM</h1>
                    <form method="POST" action="LoginServlet">
                        USERNAME: <input  type="text" name="username"> <br>
                        PASSWORD: <input  type="text" name="password"> <br> 
                        <input  type="submit" name="submit" value="LOGIN"> <br>  
                    </form>

                    
                </div>
                
                <%@include file="aside.jsp" %>
                
                <div class="clear"></div>
                
            </div>
            
                
                
            
        
        
           <%@include file="footer.jsp" %> 
        </div>
        
    </body>
</html>