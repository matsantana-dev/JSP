<%-- 
    Document   : Gravar
    Created on : 17 de set. de 2025, 16:39:02
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="model.*,controller.VeiculoDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="dao" class="controller.VeiculoDAO" scope="session"> <!-- pode ser scrope="page" -->
        </jsp:useBean>
        <%
           Veiculo obj;
           int qtde = 0;
           
        try {
            obj = new Veiculo();
            obj.setDescr(request.getParameter("txtDescr"));
            obj.setAno(request.getParameter("txtAno"));
            obj.setPreco(request.getParameter("txtPreco"));
            
            qtde = dao.gravar(obj);
            if (qtde>0) {
                out.println("<h1>" + obj.getDescr() + " salvo com sucesso.</h1>");
            } else {
                out.println("<h1> Nada foi Salvo    </h1>");
            }
        } catch (Exception ex) {
            out.println("<h1>Erro no controlador: " + ex.getMessage() + "</h1>");
        } 
         %>
    </body>
</html>
