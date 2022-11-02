package com.curso.spring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.entidades.Usuario;

@Controller
@SessionAttributes("usuario")
public class HomeController {
	
	@GetMapping("/")
	public String inicio(Model model) {
		//model.addAttribute("nombre", "David");
		
		if(model.getAttribute("usuario")==null) {
			return "redirect:/login";
		}
		return "home";
	}

}
