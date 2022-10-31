package com.curso.springcore.configuracion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MiPrueba {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ConfigurarBeansApp.class);
		
		Gestor servicio =(Gestor) context.getBean("jefe1");
		servicio.gestionar();

	}

}
