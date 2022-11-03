package com.curso.spring.servicios;

import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.repositorios.PedidoJPARepository;
import com.curso.spring.repositorios.PedidoRepository;

@Service
@Scope(value="singleton")
public class PedidoServiceImp implements PedidosService {

	private static Logger log = LoggerFactory.getLogger(PedidoServiceImp.class);
	
	@Autowired
	@Qualifier("pedidoRepo")
	private PedidoRepository repo;
	
	@Autowired
	@Qualifier("pedidoRepoJPA")
	private PedidoRepository repo2;
	
	@Autowired
	private PedidoJPARepository repoJPA;
	
	public PedidoServiceImp() {
		log.info("......... Instanciando PedidoServiceImp ");
	}
	
	@Override
	public void generarPedido(Pedido p) {
		// TODO Auto-generated method stub
		log.info("gestiono un pedido");
		//repo.add(p);
		repoJPA.saveAndFlush(p);
	}
	
	@PostConstruct
	public void init() {
		log.info(".... postvconstruct" + repo);
	}

	@Override
	public Collection<Pedido> getPedidos(String user) {
		if(user!=null) {
			return repoJPA.findAll();
		}else {
			
			Pedido pFiltro = new Pedido();
			pFiltro.setUsuario(user);
			log.info("el usuario es:" +user);
			return repoJPA.getAllByUser(user);
		}
		
	}

	@Override
	public Pedido getPedido(Integer id) {
		return repoJPA.getReferenceById(id);
	}

	@Override
	public void altaPedido(Pedido p) {
		
		repoJPA.saveAndFlush(p);
	}


}
