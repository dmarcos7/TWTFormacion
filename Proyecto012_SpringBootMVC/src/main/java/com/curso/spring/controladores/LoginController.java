package com.curso.spring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.entidades.Usuario;

@Controller
@SessionAttributes("usuario")
public class LoginController {

//	@Autowired
//	private LoginService loginService;
	
	//formulario en el que pido usuario y clave
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	//recojo los datos del formulario
	@PostMapping("/login")//recoger datos del formulario con @RequestParam
	public String irAHome(Model model, @ModelAttribute("usuario")Usuario usr) {
		
		//login service, validar nombre  clave
		usr.setRol("cliente");
		model.addAttribute("usuario",usr);
		
		//si no es valido hay que hacer return a login cuando se metan las validaciones
		return "home";
	}
}
