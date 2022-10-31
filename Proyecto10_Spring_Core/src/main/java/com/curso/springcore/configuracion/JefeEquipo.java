package com.curso.springcore.configuracion;

import javax.annotation.Resource;

public class JefeEquipo implements Gestor {

	private int equipo;
//  @Autowired
//	@Qualifier("progJava")
	@Resource(name="programadorJava")
	private Recurso recurso;

	public JefeEquipo() {
		this.equipo = 1;
	}

	public JefeEquipo(int equipo, Recurso recurso) {
		this.equipo = equipo;
		this.recurso = recurso;
	}

	@Override
	public void gestionar() {
		// TODO Auto-generated method stub
		System.out.println("GESTIONO EL EQUIPO: " + this.equipo);
		System.out.println("Iniciar Recursos ");
		recurso.trabajar();

	}

}
