package com.cristian.carrito;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carrito {
	
	private List<ElementoDeCarrito> elementosCarrito = new ArrayList<>();
	
	public Carrito(){}
	
	public Carrito(List<ElementoDeCarrito> elementosCarrito) {
		this.elementosCarrito = elementosCarrito;
	}
	
	
	public List<ElementoDeCarrito> getElementosCarrito() {
		return elementosCarrito;
	}

	public void setElementosCarrito(List<ElementoDeCarrito> elementosCarrito) {
		this.elementosCarrito = elementosCarrito;
	}

	public boolean existeElementoEncarrito(int codigo) {
		boolean localizado = false;
		for(ElementoDeCarrito e : elementosCarrito) {
			if(e.getProducto().getCodigo() == codigo) {
				localizado = true;
			}
		}
		return localizado;
	}
	
	public int posicionElementoCarrito(int codigo) {
		for(int i = 0; i < elementosCarrito.size(); i++) {
			ElementoDeCarrito e = elementosCarrito.get(i);
			if(e.getProducto().getCodigo() == codigo) {
				return i;
			}
		}
		return -1;		
	}
	
	public void meterProducto(int codigo) {
		if(existeElementoEncarrito(codigo)){
			for(ElementoDeCarrito e: elementosCarrito) {
				if(e.getProducto().getCodigo() == codigo) {
					e.setCantidad(e.getCantidad() + 1);					
				}
			}
		} else {
			Catalogo catalogo = new Catalogo();
			for(Producto p: catalogo.getProductos()) {
				if(p.getCodigo() == codigo) {
					elementosCarrito.add(new ElementoDeCarrito(p, 1));
				}
			}
		}		
	}
	
	public void eliminarproducto(int codigo) {
		Iterator<ElementoDeCarrito> iterator = elementosCarrito.iterator();
			while (iterator.hasNext()) {
		        ElementoDeCarrito e = iterator.next();
		        if (e.getProducto().getCodigo() == codigo) {
		            if (e.getCantidad() > 1) {
		                e.setCantidad(e.getCantidad() - 1);
		                return;
		            } else {
		            	iterator.remove();
		            	return;
		            }
		        }
		    }
		}  
	
}
