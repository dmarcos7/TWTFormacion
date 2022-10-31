package com.curso.springcore.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.curso")
@ImportResource("classpath:mis-beans.xml")
//@Import(OtroJavaConfig.class)
public class ConfigurarBeansApp {
	
	@Bean
	public JefeEquipo jefe1() {
		return new JefeEquipo();
	}

	
	@Bean
	//@Qualifier("programador1")
	public Programador programador1() {
		Programador p = new Programador();
		p.setTarea("Programo en PLSQL");
		return p;
	}
	
	@Bean
	@Scope(value="prototype")
	//@Qualifier("programadorJava")
	public Programador programadorJava() {
		Programador p = new Programador();
		p.setTarea("Programo en Java");
		return p;
	}
	
	
}
