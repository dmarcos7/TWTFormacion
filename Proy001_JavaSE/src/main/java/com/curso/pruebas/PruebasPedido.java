package com.curso.pruebas;

import java.util.Date;

import com.curso.varios.Pedido;

public class PruebasPedido {
	
	public static void main(String[] args) {
		
		Pedido p = new Pedido(1);
		
		p.setCantidad(10);
		p.setIdProducto(45);
		p.setFechaPedido(new Date());
		p.setObservaciones("");
		
		//muestra la direccion de memoria
		System.out.println(p);
		Pedido p2 = p;
		System.out.println(p2);
	}

}
