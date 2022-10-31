package com.curso.springcore.equipo;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurarBeansApp {
	
	@Bean
	public JefeEquipo jefe1() {
		return new JefeEquipo();
	}
	
	@Bean
	@Qualifier("programador1")
	public Programador programador1() {
		Programador p = new Programador();
		p.setTarea("Programo en PLSQL");
		return p;
	}

}
