<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cristian.carrito.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comprar producto</title>
</head>
<body>
<% 
	
	System.out.println("codigo= " + request.getParameter("codigo"));
	int codigo = Integer.parseInt(request.getParameter("codigo"));
	Carrito carrito = (Carrito) session.getAttribute("carrito");
	carrito.meterProducto(codigo);
	session.setAttribute("carrito", carrito);
	response.sendRedirect("index.jsp");
	
%>

</body>
</html>