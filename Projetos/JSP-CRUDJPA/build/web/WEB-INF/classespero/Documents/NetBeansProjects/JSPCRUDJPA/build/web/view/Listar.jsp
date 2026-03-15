<%-- 
    Document   : Listar
    Created on : 15 de set. de 2025, 15:21:04
    Author     : prampero
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  language="java" import="model.*,controller.VeiculoDAO" %>
<%@page import="java.util.List"%>
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
            List<Veiculo> lista;
            lista=dao.listar();
        %>
        <p align='center'>
            <font size='20px'>Lista de Veículos <%=request.getParameter("meuNome")%>
            </font></p>
        <table align='center' border='1'>
            <thead>
            <tr>
            <th>Código</th>
            <th>Modelo</th>
            <th>Ano</th>
            <th>Preço</th>
            </tr>
            <thead>
            <tbody>
        <%
            for(Veiculo v :lista){
        %>
        <tr>
        <td> <%=v.getCodigo()%> </td>
        <td> <%=v.getDescr()%> </td>
        <td> <%=v.getAno()%> </td>
        <td> <%=v.getPreco()%> </td>
        </tr>
        <%
            }
        %>
        </tbody>
        </table>
    </body>
</html>
