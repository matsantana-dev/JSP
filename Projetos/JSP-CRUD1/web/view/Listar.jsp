<%-- 
    Document   : Listar
    Created on : 17 de set. de 2025, 16:53:29
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="model.*,controller.VeiculoDAO, java.sql.ResultSet" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ResultSet tabela = null;
            VeiculoDAO dao;
            
        try {
            dao = new VeiculoDAO();
            tabela = dao.listar();
            %>
            <h1>FRU FRU :0</h1>
            <%=dao.gerarTabela(tabela) %>
            <%
        } catch (Exception ex) {
            out.println("<h1>Erro: " + ex.getMessage() + "</h1>");
        }
        %>
    </body>
</html>
