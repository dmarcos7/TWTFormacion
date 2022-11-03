package com.curso.spring.controladores;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.entidades.Usuario;
import com.curso.spring.servicios.PedidosService;

@Controller
@SessionAttributes("usuario")
public class PedidosController {
	
	@Autowired
	private PedidosService pedidoService;
	
	@GetMapping("/pedidos")
	public String pedidos(Model model) {
		//pedir la lista de pedidos del usuario que este de sesion
		Usuario usuario = (Usuario) model.getAttribute("usuario");
		Collection<Pedido> pedidos = pedidoService.getPedidos(null);
		model.addAttribute("listaPedidos", pedidos);
		return "pedidos";
	}
	
	//localhos:8080/pedidos/nombre
	//{username} path variable
	@GetMapping("/pedidos/{username}")
	public String pedidosCliente(Model model, @PathVariable("username")String name) {
		
		Collection<Pedido> pedidos = pedidoService.getPedidos(name);
		model.addAttribute("listaPedidos", pedidos);
		return "pedidos";
	}
	
	
	//?variable=1 request param
	@GetMapping("/pedido")
	public String verDetallePedido(Model model, @RequestParam("idPedido") Optional<Integer> id) {
		
		Integer idCliente = id.orElse(null);
		if(id.isEmpty()) {
			return "redirect:/pedidos";
		}
		System.out.println(idCliente);
		Pedido p = pedidoService.getPedido(idCliente);
		model.addAttribute("pedido", p);
		return "detalle-pedido";
	}
	
	
	@GetMapping("/altaPedido")
	public String altaPedido(Model model) {
		model.addAttribute("pedidoForm", new Pedido());
		
		return "alta-pedido";
	}
	
	@PostMapping("/altaPedido")
	public String altaPedido(Model model,@Valid @ModelAttribute("pedidoForm")Pedido pedido
			,BindingResult bindingRes) {
		
		if(bindingRes.hasErrors()) {
			return "alta-pedido";
		}
		Usuario u = (Usuario) model.getAttribute("usuario");
		pedido.setUsuario(u.getNombre());
		pedidoService.altaPedido(pedido);
		pedido.setFechaPedido(new Date());
		Collection<Pedido> pedidos = pedidoService.getPedidos(u.getNombre());
		
		model.addAttribute("pedidos", pedidos);
		
		return "pedidos";
	}

}
