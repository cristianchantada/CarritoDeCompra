package com.cristian.carrito;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
	
	private List<ElementoEnCarrito> elementosCarrito = new ArrayList<>();
	private Catalogo catalogo = new Catalogo();
	
	public Carrito(){}
	
	public Carrito(List<ElementoEnCarrito> elementosCarrito) {
		this.elementosCarrito = elementosCarrito;
	}
	
	public boolean existeElementoEncarrito(int codigo) {
		boolean localizado = false;
		for(ElementoEnCarrito e : elementosCarrito) {
			if(e.getProducto().getCodigo() == codigo) {
				localizado = true;
			}
		}
		return localizado;
	}
	
	public int posicionElementoCarrito(int codigo) {
		
	}
	
	public void meterProducto(int codigo) {
		if(existeElementoEncarrito(codigo)){
			
		} else {
			Catalogo catalogo = new Catalogo();
			
			elementosCarrito.add(new Producto());
		}		
	}
	
	public void eliminarproducto(int codigo) {
		
	}
}
