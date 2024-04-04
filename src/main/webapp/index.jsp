<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.cristian.carrito.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xogos Tradicionais Galegos</title>
    <link rel="stylesheet" href="styles/style.css">
</head>
<body>
    <h1>Xogos Tradicionais Galegos</h1>
    <div class="container">
        <div class="products-container">
            <% Catalogo catalogo = new Catalogo();
               for (Producto producto : catalogo.getProductos()) { %>
                <div class="product-card">
                    <div class="product-image">
                        <img src="imgs/<%= producto.getCodigo() %>.png" alt="<%= producto.getNombre() %>">
                    </div>
                    <div class="product-details">
                        <h4><%= producto.getNombre() %></h4>
                        <p><%= producto.getPrecio() %>€</p>
                        <a href="comprar.jsp?codigo=<%= producto.getCodigo() %>" class="btn">Comprar</a>
                    </div>
                </div>
            <% } %>
        </div>
        <div class="cart-container">
            <h3>Carrito de la compra</h3>
            <% Carrito carrito;
               if (session.getAttribute("carrito") != null) {
                   carrito = (Carrito) session.getAttribute("carrito");
               } else {
                   carrito = new Carrito();
                   session.setAttribute("carrito", carrito);
               }
               List<ElementoDeCarrito> elementosCarrito = carrito.getElementosCarrito();
               double total = 0;
               for (ElementoDeCarrito e : elementosCarrito) {
                   total += e.getProducto().getPrecio() * e.getCantidad();
            %>
                <div class="cart-item">
                    <div class="product-image">
                        <img src="imgs/<%= e.getProducto().getCodigo() %>.png" alt="<%= e.getProducto().getNombre() %>">
                    </div>
                    <div class="cart-item-details">
                        <h4><%= e.getProducto().getNombre() %></h4>
                        <p>Precio: <%= e.getProducto().getPrecio() %>€</p>
                        <p>Cantidad: <%= e.getCantidad() %></p>
                        <p>Total: <%= e.getProducto().getPrecio() * e.getCantidad() %>€</p>
                    	<a href="eliminar.jsp?codigo=<%=e.getProducto().getCodigo()%>">Eliminar
						unidad</a>
                    </div>
                </div>
            <% } %>
            <div class="cart-total">
                <h4>Total: <%= total %>€</h4>
                <a href="checkout.jsp" class="checkout-btn">Pagar</a>
            </div>
        </div>
    </div>
</body>
</html>
