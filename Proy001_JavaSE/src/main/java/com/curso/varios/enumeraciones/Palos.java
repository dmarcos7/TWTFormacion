package com.curso.varios.enumeraciones;

public enum Palos {
	
	OROS,
	BASTOS,
	COPAS,
	ESPADAS

}

//Enumeraciones avanzadas (como simple curiosidad
enum ModelosCoche{
	BASICO("Solo tiene motor y ruedas"),
	MEDIO ("aireacondicionado"),
	SUPEIOR("con navegador"); // si quieres definir todo lo de abajo tiene que acabar en puunto y coma la enum
	
	//ATRIBUTOS
	private String descripcion;
	//CONSTRUCTORES
	private ModelosCoche(String s) {
		this.descripcion = s;
	}
	//METODOS
	
	public String getDescripcion() {
		return descripcion;
	}
}
