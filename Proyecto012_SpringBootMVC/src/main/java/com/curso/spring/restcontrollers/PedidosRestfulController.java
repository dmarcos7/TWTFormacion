package com.curso.spring.restcontrollers;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.excepciones.PedidosException;
import com.curso.spring.servicios.PedidosService;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"},
methods= {RequestMethod.GET, 
		RequestMethod.DELETE, 
		RequestMethod.PUT,
		RequestMethod.POST, 
		RequestMethod.OPTIONS})
public class PedidosRestfulController {
	private static Logger log = LoggerFactory.getLogger(PedidosRestfulController.class);
	
	@Autowired
	private PedidosService pedidoService;
	
	
	//FIND ALL
	@GetMapping("/ws/pedidos")
	public Collection<Pedido> getAll(){
		return pedidoService.getPedidos(null);
	}
	
	//GET BY ID
	@GetMapping("/ws/pedidos/{id}")
	public Pedido getById(@PathVariable("id") Integer id) {
		Optional<Pedido> p = pedidoService.getPedido(id);
		return p.get();
	}
	
	
	//INSERT
	@PostMapping("/ws/pedidos/insertar")
	public Pedido insertar(@RequestBody Pedido newPedido) {
		newPedido.setFechaPedido(new Date());
		newPedido =  pedidoService.altaPedido(newPedido);
		return newPedido;
	}
	
	//DELETE
	@DeleteMapping("/ws/pedidos/borrar/{id}")
	public void borrar(@PathVariable("id")Integer id) throws PedidosException {
		
		pedidoService.borrarPedido(id);
		//return "{ok}";		
	}
	
	//UPDATE
	
	@PutMapping("/ws/pedidos/modificar/{id}")
	public Pedido modificar(@PathVariable("id") Integer id, @RequestBody Pedido p) {
		p.setFechaPedido(new Date());
		p.setId(id);
		log.info(p.toString());
		return pedidoService.modificarPedido(p);
		
	}
	
//	@ExceptionHandler({PedidosException.class, Exception.class})
//	public String manejarExcepcion(HttpServletRequest req, Exception e) {
//		return "error"+e.getMessage();
//	}

}
