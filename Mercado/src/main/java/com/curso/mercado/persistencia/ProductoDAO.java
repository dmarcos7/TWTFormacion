package com.curso.mercado.persistencia;

import java.util.List;

import com.curso.mercado.bd.BaseDatosMercado;
import com.curso.mercado.entidades.Producto;

public class ProductoDAO implements GenericDAO<Producto> {

	private BaseDatosMercado bd;
	@Override
	public void add(Producto entidad) {
		
		BaseDatosMercado.getBaseDatosMercado().add(entidad);
		System.out.println("graba en bd " + entidad);
		
	}

	@Override
	public List<Producto> getAll() {
		// TODO crear y devolver una lista de productos
		return null;
	}

}
