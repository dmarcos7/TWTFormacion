package com.curso.springcore.equipo;

public class Programador implements Recurso{
	
	private String tarea;
	
	public Programador() {
		this.tarea = "Programar";
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	@Override
	public void trabajar() {
		// TODO Auto-generated method stub
		System.out.println("Realizo la tarea: "+this.tarea);
	}
	

}
