package com.curso.mercado.servicios;

import java.util.List;

import com.curso.db.PoolConexiones;
import com.curso.mercado.entidades.Producto;
import com.curso.mercado.persistencia.GenericDAO;
import com.curso.mercado.persistencia.ProductoDataBaseDAO;
import com.curso.mercado.persistencia.ProductoDataBaseJPA;

public class ProductosService {
	
	GenericDAO<Producto> dao;
	
	
	public ProductosService() {
		//PoolConexiones pool = new PoolConexiones();
		
		//dao = new ProductoDataBaseDAO(pool.getConexion());
		dao = new ProductoDataBaseJPA();
	}
	public void darAltaUnproducto(Producto p) {
		// valida que p no es null
		//validar descripcion 
		//validar precio
		
		dao.add(p);
		
	}
	
	public List<Producto>  dameTodosLosProductos() {
		return dao.getAll();
	}

}
