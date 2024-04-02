package com.cristian.carrito;

public class Producto {
	
	private int codigo;
	private String nombre;
	private double precio;
	private String img;
	
	public Producto(){}
	
	public Producto(int codigo, String nombre, double precio, String img) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.img = img;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
