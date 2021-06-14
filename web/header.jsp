

<%@page import="java.util.List"%>
<%@page import="database.Upiti"%>
<%@page import="model.Category"%>
<%
            String username1 = "";
            try {
                Object u = request.getSession().getAttribute("username");
                username1 = u.toString();
            } catch (Exception e) {
            }
            
            List<Category> kategorije1 = Upiti.getAllCategories();
            
%>




<header>

    <div id="headerbox">

        <div id="title">
            <div id="titletext">
                <p> BIKE SHOP BUY A BIKE </p>

            </div>

            <div id="logos">
                
                
                <div class="logo">
                    <a href="mailto:webmaster@example.com"> <img src="img/ml_ico.png" alt="ml_logo" > </a>             
                </div>
                <div class="logo">
                    <a href="http://www.facebok.com" target="_blank"> <img src="img/fb_ico.png" alt="fb_logo" > </a>       
                </div>
                <div class="logo">
                    <a href="http://www.twitter.com" target="_blank"> <img src="img/tw_ico.png" alt="fb_logo" > </a> 
                </div>
                <div class="logo">
                    <a href="http://www.instagram.com"  target="_blank"> <img src="img/in_ico.png" alt="in_logo" > </a>             
                </div>
                
                
            </div>
        </div>


        <nav>

            <ul>

                <a href="index.jsp" > <li> HOME PAGE </li></a>
                
                
                               
                
                <% if (username1.equals("")) { %>
                <a href ="login.jsp"> <li class="navbtn" id="login"> LOGIN </li> </a> 
                <% } else {%>
                 <a href ="Logout"> <li class="navbtn" id="logout"> LOGOUT </li> </a> 
                <% } %>
                
                <% if (username1.equals("admin")) { %>
                <a href ="admin.jsp"> <li class="navbtn" id="admin"> ADMIN </li> </a> 
                <% }%>


                <% if (username1.equals("")) { %>
                <a href="register.jsp" > <li class="navbtn" id="register"> REGISTER </li> </a>
                <% } else if (!username1.equals("admin")) {%>
                 <a href ="transaction.jsp"> <li class="navbtn" id="logout"> <%=username1.toUpperCase() %> </li> </a>
               <% }%>
                
                <% 
                    
                    for(int i=0; i<kategorije1.size(); i++) { %>
                <a href ="category.jsp?id=<%=kategorije1.get(i).getId()%>"> <li > <%=kategorije1.get(i).getName() %> </li> </a>
                <% } %>
                
                
                
            </ul>

        </nav>

    </div>


</header>
