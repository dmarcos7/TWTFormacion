package com.curso.springcore.pedidos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.springcore.equipo.Gestor;

public class Prueba {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans-con-anotaciones.xml");
	
	
		GestionPedidosService servicio =(GestionPedidosService) context.getBean("gestionPedidosABC");
		servicio.gestionar();
	}

}
