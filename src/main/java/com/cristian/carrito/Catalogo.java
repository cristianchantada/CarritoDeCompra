package com.cristian.carrito;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	
	private List<Producto> productos = new ArrayList();
	
	public List<Producto> cargarProductos(){
		productos.clear();
		productos.add(
				new Producto(1, "juegoTradicional1", 300, "juegoTradicional1.jpg")
				);
		productos.add(
				new Producto(2, "juegoTradicional2", 180, "juegoTradicional2.jpg")
				);
		productos.add(
				new Producto(3, "juegoTradicional3", 250, "juegoTradicional3.jpg")
				);
		productos.add(
				new Producto(4, "juegoTradicional4", 280, "juegoTradicional4.jpg")
				);
		productos.add(
				new Producto(5, "juegoTradicional5", 120, "juegoTradicional5.jpg")
				);
		productos.add(
				new Producto(6, "juegoTradicional6", 350, "juegoTradicional6.jpg")
				);
		productos.add(
				new Producto(7, "juegoTradicional7", 100, "juegoTradicional7.jpg")
				);
		productos.add(
				new Producto(8, "juegoTradicional8", 70, "juegoTradicional8.jpg")
				);
		
		return productos;
	}
	
	public List<Producto> getProductos(){
		return productos;
	}
	
	public Producto getProducto(int codigo) {
		Producto producto = (Producto) productos
				.stream()
				.filter(p -> p.getCodigo() == codigo);
		
		return producto;
	
	}
	


}
