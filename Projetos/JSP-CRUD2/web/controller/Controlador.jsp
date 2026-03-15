<%-- 
    Document   : Controlador
    Created on : 17 de set. de 2025, 16:27:32
    Author     : prampero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String botao="";
        try{
                botao=request.getParameter("b1").trim().toLowerCase();
                switch(botao){
                
                case "gravar":
                        request.getRequestDispatcher("../view/Gravar.jsp").
                        forward(request, response);
                        break;
                case "listar":
                %>
                <jsp:forward page="../view/Listar.jsp">
                    <jsp:param name="meuNome" value="Prampero"></jsp:param>
                </jsp:forward> 
                <%
            }
            out.println("<h1>Evento "+botao+" não tratado </h1>");
        }
        catch(Exception ex){
            out.println("<h1>Erro no controlador:"+ex.getMessage()+"  </h1>");
            }
        %>
    </body>
</html>
