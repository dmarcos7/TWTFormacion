package com.curso.spring.restcontrollers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.servicios.PedidosService;

@RestController
public class PedidosRestfulController {
	
	
	@Autowired
	private PedidosService pedidoService;
	
	
	//FIND ALL
	@GetMapping("/ws/pedidos")
	public Collection<Pedido> getAll(){
		return pedidoService.getPedidos(null);
	}
	
	//GET BY ID
	
	
	
	//INSERT
	
	
	//DELETE
	
	
	//UPDATE

}
