package com.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String inicio(Model model) {
		model.addAttribute("saludo", "Bienvenido a la tienda online");
		model.addAttribute("linea1", "Los mejores precios");
		
		return "home"; //nombre de la página JSP a la que quieres ir
	}
	
	
	@RequestMapping("/saludo")
	public String saludo(Model model) {
		model.addAttribute("saludo", "Bienvenido a la tienda online");
		model.addAttribute("linea1", "Los mejores precios");
		
		return "home"; //nombre de la página JSP a la que quieres ir
	}

}
