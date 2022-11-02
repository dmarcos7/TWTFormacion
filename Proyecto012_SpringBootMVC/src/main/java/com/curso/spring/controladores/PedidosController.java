package com.curso.spring.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		Collection<Pedido> pedidos = pedidoService.getPedidos(usuario.getNombre());
		model.addAttribute("listaPedidos", pedidos);
		return "pedidos";
	}

}
