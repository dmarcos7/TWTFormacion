package com.curso.springcore.pedidos;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gestionPedidosABC")
public class GestionPedidosServiceImp implements GestionPedidosService {

	@Autowired
	private Pedido pedido;
	@Override
	public void gestionar() {
		System.out.println("..........GESTIONANDO...........");
		
	}
	
	//Cuando es necesario que se ejecute inmediatamente despues
	// del constructor
	@PostConstruct
	public void inicio() {
		
	}
	//hace lo que sea antes de destruir el contenedor de beans
	//se ejecuta cuando se destruya ese contenedor
	@PreDestroy
	public void destruir() {
		
	}

}
