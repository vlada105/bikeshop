
<%@page import="model.Frame"%>
<%@page import="java.util.List"%>
<%@page import="database.Upiti"%>
<%@page import="model.Brand"%>
<%
    List<Brand> listabrendova1 = Upiti.getAllBrands();
    
    List<Frame> frames = Upiti.getAllFrames();
    
%>




<aside>
    
    <ul>

        <% for (int i = 0; i < listabrendova1.size(); i++) {%>
            <a href ="brand.jsp?id=<%=listabrendova1.get(i).getId() %>"> <li > <%=listabrendova1.get(i).getName()   %> </li> </a>
        <% }%>

    </ul>

    <hr><hr>

    <ul>

        <% for (int i = 0; i < frames.size(); i++) {%>
            <a href ="frame.jsp?id=<%=frames.get(i).getId() %>"> <li > <%=frames.get(i).getMaterial()  %> </li> </a>
        <% }%>

    </ul>

</aside>