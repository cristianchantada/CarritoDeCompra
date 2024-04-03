
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cristian.carrito.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xogos Tradicionais galegos</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
<% 
	Catalogo catalogo = new Catalogo();
	Carrito carrito;

	if(session.getAttribute("carrito") != null){
		carrito = (Carrito) session.getAttribute("carrito");
	} else {
		carrito = new Carrito();
		session.setAttribute("carrito", carrito);
	}
	
	List<ElementoDeCarrito> elementosCarrito = carrito.getElementosCarrito();
	
	%>
	<h1>Xogos Tradicionais:</h1>
	
	<div class="main-container">
	<%
		for(Producto producto: catalogo.getProductos()){
	%>	
		<div class="product-card">
			<div class="img-container">
				<img alt="" src=<%= "imgs/" + producto.getCodigo() + ".png"%>>
			</div>
			<div class="data-container">
				<h4><%= producto.getNombre() %></h4>
				<h5><%= producto.getPrecio()%> €</h5>
				<a href="comprar.jsp?codigo=<%= producto.getCodigo() %>">Comprar</a>
			</div>
		</div>
	<%}%>	
		
	</div>
	<div class="cart-container">
		<h3>Carrito de la compra:</h3>
		<% for(ElementoDeCarrito e: elementosCarrito) {%>
		<div class="product-card">
			<div class="img-container">
				<img alt="" src=<%= "imgs/" + e.getProducto().getCodigo() + ".png"%>>
			</div>
			<div class="data-container">
				<h4><%= e.getProducto().getNombre() %></h4>
				<h5><%= e.getProducto().getPrecio()%> €</h5>
				<a href="eliminar.jsp?codigo=" + <%= e.getProducto().getCodigo() %>></a>
			</div>
		</div>
			
		
		<%}%>
	</div>
	
</body>
</html>