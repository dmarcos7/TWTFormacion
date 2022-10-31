package com.curso.springcore.equipo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MiPrueba {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans-con-anotaciones.xml");
		
		Gestor servicio =(Gestor) context.getBean("jefe1");
		servicio.gestionar();

	}

}
