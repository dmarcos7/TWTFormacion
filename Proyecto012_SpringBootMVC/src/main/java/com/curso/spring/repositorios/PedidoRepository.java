package com.curso.spring.repositorios;

import java.util.Collection;

import com.curso.spring.entidades.Pedido;

public interface PedidoRepository {
	
	void add(Pedido pedido);
	Collection<Pedido> getPedidosByUser(String user);
	Collection<Pedido> getAll();
	Pedido getById(Integer id);
	void addPedido(Pedido p);

}
