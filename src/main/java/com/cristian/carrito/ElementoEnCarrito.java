package com.cristian.carrito;

public class ElementoEnCarrito {
	
	private Producto producto;
	private int cantidad;
	
	public ElementoEnCarrito() {}

	public ElementoEnCarrito(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void incrementaCantidad() {
		cantidad++;
	}

}
