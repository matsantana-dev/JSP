<%-- 
    Document   : Gravar
    Created on : 15 de set. de 2025, 14:21:02
    Author     : prampero
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
        <%
            VeiculoDAO dao;
            Veiculo obj;
    
            try{
                obj = new Veiculo();
                obj.setCodigo(request.getParameter("txtCodigo"));
                obj.setDescr(request.getParameter("txtDescr"));
                obj.setAno(request.getParameter("txtAno"));
                obj.setPreco(request.getParameter("txtPreco"));
                
                dao = new VeiculoDAO();
               dao.alterar(obj);
          
                out.print("<h1>Alterador com sucesso. </h1>");
                
            
            }
            catch(Exception ex){
                out.println("<h1> Erro: "+ex.getMessage()+"</h1>");
            }
         %>
    </body>
</html>
