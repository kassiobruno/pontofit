<%-- 
    Document   : adm-logout
    Created on : 20/11/2016, 01:16:01
    Author     : kassio
--%>
        <%
            session = request.getSession();
            session.removeValue("usuario");
            session.removeValue("tipo");
            session.removeValue("permissao");
            session.invalidate();            
            response.sendRedirect("index.html");
        %>
    </body>
</html>
