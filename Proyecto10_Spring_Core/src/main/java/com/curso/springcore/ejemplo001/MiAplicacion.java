package com.curso.springcore.ejemplo001;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MiAplicacion {

	public static void main(String[] args) {
		
		//SIN SPRING SIN INYECCION DE LA DEPENDENCIA
		SaludoService servicio = new SaludoServiceImp();
		servicio.saludar("Amigo");

		System.out.println("......................................");
		// CON SPRING IOC
		
		// ya no voy a crear nunca mas una instacia de la clase
		//SALUDOIMP
		//voy a solicitar el contenedor de Beans de Spring
		//que me entrege una instancia
		ApplicationContext ctx = new ClassPathXmlApplicationContext("mis-beans.xml");
		
		
		SaludoService s1 = (SaludoService) ctx.getBean("saludador1");
		s1.saludar("soy saludador1");
		

		SaludoService s2 = (SaludoService) ctx.getBean("saludadorAdios");
		s1.saludar("soy saludadorAdios");
		
		
		
	}

}
