<%-- 
    Document   : Controlador
    Created on : 15 de set. de 2025, 14:10:21
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
        <%
            response.setCharacterEncoding("UTF-8");
            String botao = request.getParameter("b1").trim().toLowerCase();
            try {
                switch (botao) {
                    case "gravar":
                        request.getRequestDispatcher("../view/Gravar.jsp").forward(request, response);
                        break;
                    case "alterar":
                        request.getRequestDispatcher("../view/Alterar.jsp").forward(request, response);
                        break;
                    case "remover":
                        request.getRequestDispatcher("../view/Remover.jsp").forward(request, response);
                        break;
                    case "listar":
        %>
                        <jsp:forward page="../view/Listar.jsp">
                            <jsp:param name="meuNome" value="Prampero"></jsp:param>
                        </jsp:forward>
        <%
                        break;
                }
            } catch (Exception ex) {
                out.println("<h1>Erro:" + ex.getMessage() + "  </h1>");
            }
        %>
        <h1> Evento não tratado <%=botao%> </h1>
    </body>
</html>
