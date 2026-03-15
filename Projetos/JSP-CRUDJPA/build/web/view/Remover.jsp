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
            int codigo;
            int qtde=0;
            try{
                
                codigo=Integer.parseInt(request.getParameter("txtCodigo"));
                                
                dao = new VeiculoDAO();
                dao.remover(Veiculo.class, codigo);
          
                out.print("<h1>Removido com sucesso. </h1>");
                
            
            }
            catch(Exception ex){
                out.println("<h1> Erro ao remover: "+ex.getMessage()+"</h1>");
            }
         %>
    </body>
</html>
