package com.curso.spring.repositorios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.curso.spring.entidades.Pedido;

@Repository
@Qualifier("pedidoRepo")
public class PedidoRepositoryImp implements PedidoRepository {

	private static Logger log = LoggerFactory.getLogger(PedidoRepositoryImp.class);
	
	private static Map<Integer,Pedido> pedidos= new HashMap<Integer,Pedido>();
	private static int id;
	static {
		pedidos.put(1, new Pedido(1,"David", "Television", new Date(),true));
		pedidos.put(2, new Pedido(2,"David", "Libro", new Date(),true));
		pedidos.put(3, new Pedido(3,"Maite", "Moto", new Date(),true));
		id=3;
	}
	
	@Override
	public void add(Pedido pedido) {
		id++;
		pedido.setId(id);
		pedidos.put(id, pedido);
		log.info("Has realizado un pedido, se ha guardado en la base de datos");
		
	}

	@Override
	public Collection<Pedido> getPedidosByUser(String user) {
		Collection<Pedido> lista = new ArrayList<>();
		for(Pedido p: pedidos.values()) {
			if(p.getUsuario().equalsIgnoreCase(user)) {
				lista.add(p);
			}
		}
		return lista;
	}

	@Override
	public Collection<Pedido> getAll() {
		
		return pedidos.values();
	}

	@Override
	public Pedido getById(Integer id) {
	
		return pedidos.get(id);
	}

	@Override
	public void addPedido(Pedido p) {
		Integer id = pedidos.keySet().size()+1;
		p.setId(id);
		p.setEntregado(false);
		p.setFechaPedido(new Date());
		pedidos.put(id, p);
	}

}
