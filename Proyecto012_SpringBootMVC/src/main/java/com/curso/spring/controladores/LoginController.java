package com.curso.spring.controladores;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		model.addAttribute("usuarioForm", new Usuario());
		return "login";
	}
	//recojo los datos del formulario
	@PostMapping("/login")//recoger datos del formulario con @RequestParam
	public String irAHome(Model model, @Valid @ModelAttribute("usuarioForm")Usuario usr,
			BindingResult bindingRes) {
		
		boolean valido = true;
		
		//ver si paso la validacion
		if(bindingRes.hasErrors()) {
			return "login";
		}
		//realmente la validacion deberia realizarse en el service
		//login service, validar nombre  clave
		if(usr.getNombre().trim().equalsIgnoreCase("DAVID")) {
			usr.setRol("cliente");
		}else{
			usr.setRol("admin");
		}
		
		if(valido) {
			model.addAttribute("usuario",usr);
		}
		
		
		//si no es valido hay que hacer return a login cuando se metan las validaciones
		return "home";
	}
}
