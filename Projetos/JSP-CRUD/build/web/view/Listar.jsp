<%-- 
    Document   : Listar
    Created on : 15 de set. de 2025, 15:21:04
    Author     : prampero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  language="java" import="model.*,controller.VeiculoDAO,java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="dao" class="controller.VeiculoDAO" scope="page">
        </jsp:useBean>
        <%
            ResultSet tabela;
            tabela=dao.listar();
        %>
        <p align='center'>
            <font size='20px'>Lista de Veículos <%=request.getParameter("meuNome")%>
            </font></p>
        <%=dao.gerarTabela(tabela)%>
    </body>
</html>
