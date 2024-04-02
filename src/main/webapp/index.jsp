
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cristian.carrito.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xogos Tradicionais galegos</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f0f0f0;
    }

    .main-container {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
        grid-gap: 20px;
        padding: 20px;
    }

    .product-card {
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        overflow: hidden;
    }

    .product-card img {
        width: 100%;
        height: auto;
        display: block;
    }

    .product-card div {
        padding: 20px;
    }

    .product-card h4 {
        margin: 0 0 10px;
        font-size: 18px;
    }

    .product-card h5 {
        margin: 0;
        font-size: 16px;
        color: #555;
    }
</style>
</head>
<body>
<% 
	Catalogo catalogo = new Catalogo();
	
	%>
	<h1>Xogos Tradicionais:</h1>
	
	<div class="main-container">
	<%
		for(Producto producto: catalogo.getProductos()){
	%>	
		<div class="product-card">
			<img alt="" src=<%= "imgs/" + producto.getCodigo() + ".png"%>>
			<div>
				<h4><%= producto.getNombre() %></h4>
				<h5><%= producto.getPrecio()%> €</h5>
			
			</div>
		</div>
	<%}%>	
		
	</div>
	
</body>
</html>