package com.curso.spring.repositorios;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.curso.spring.entidades.Pedido;

@Repository
@Qualifier("pedidoRepoJPA")
public class PedidoJPARespositoryImp implements PedidoRepository {
	private static Logger log = LoggerFactory.getLogger(PedidoJPARespositoryImp.class);
	@Override
	public void add(Pedido pedido) {
		log.info("Pedido JPA");

	}
	@Override
	public Collection<Pedido> getPedidosByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Collection<Pedido> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Pedido getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addPedido(Pedido p) {
		// TODO Auto-generated method stub
		
	}

}
