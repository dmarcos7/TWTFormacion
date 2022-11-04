package com.curso.spring.servicios;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;
//import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.repositorios.PedidoJPARepository;
import com.curso.spring.repositorios.PedidoRepository;

@Service
@Scope(value="singleton")
@Transactional(propagation = Propagation.REQUIRED)
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
	@Transactional(readOnly = true)
	public Collection<Pedido> getPedidos(String user) {
		if(user==null) {
			return repoJPA.findAll();
		}else {
			
			Pedido pFiltro = new Pedido();
			pFiltro.setUsuario(user);
			log.info("el usuario es:" +user);
			return repoJPA.getAllByUser(user);
		}
		
	}

	@Override
	public Optional<Pedido> getPedido(Integer id) {
		return repoJPA.findById(id);
	}

	@Override
	public Pedido altaPedido(Pedido p) {
		
		return repoJPA.save(p);
	}

	@Override
	public void borrarPedido(Integer id) {
		repoJPA.deleteById(id);
		
	}


}
