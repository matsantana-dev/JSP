<%-- 
    Document   : Listar
    Created on : 17 de set. de 2025, 16:53:29
    Author     : prampero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="model.*,controller.VeiculoDAO,java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgColor='plum'>
        <%
            ResultSet tabela=null;
            VeiculoDAO dao;
            try{
              dao=new VeiculoDAO();
              tabela=dao.listar();
              %>
              <p align='center'> <font size='20px'>Listar veículos</font></p>
              <%=dao.gerarTabela(tabela)%>
              <%
            }
            catch(Exception ex){
                out.println("<h1>Erro:"+ex.getMessage()+" </h1>");
         }
        %>
    </body>
</html>
