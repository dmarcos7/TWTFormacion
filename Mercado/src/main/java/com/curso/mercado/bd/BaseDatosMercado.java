package com.curso.mercado.bd;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.curso.mercado.entidades.*;

public class BaseDatosMercado {
	private static Map<Integer, Producto> listaProductos;
	private static BaseDatosMercado bd;
	private static int contador = 1;
	
	//inicializado
	//TODO AÑADIR EXCEPCIONES Y LAS VALIDACIONES NECESARIAS PARA EL EJERCICIO
	
	static {
		listaProductos = new HashMap<Integer, Producto>();
		listaProductos.put(contador++, new Producto(1, "Libro Recetas", 30.0));
		listaProductos.put(contador++, new Producto(2,"Jarrón Chino", 340.0));
		listaProductos.put(contador++, new Producto(3, "Lápiz",3.0));
	}
	
	private BaseDatosMercado() {
		
	}
	
	public static BaseDatosMercado getBaseDatosMercado(){
		if(bd == null) {
			bd= new BaseDatosMercado();
		}
		return bd;
	}
	
	
	
	public void add(Producto p) {
		listaProductos.put(contador++, p);
		System.out.println("Producto añadido");
	}
	
	public Producto solocitarPorId(Integer id) {
		return listaProductos.get(id);
	}
	
	public Collection<Producto> getListaProductos(){
		return listaProductos.values();
	}
	
	public void borrarProducto(int id) {
		listaProductos.remove(id);
	}
	
	public void acualizarProducto(Producto producto) {
		listaProductos.put(producto.getIdProducto(), producto);
	}
	
	public static int getContador() {
		return contador;
	}
	 
	
}
