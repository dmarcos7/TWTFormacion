package com.curso.varios;

/* 
 * JVM cargar la clase com.curso.varios.Saludador  (Full Qualified Name)
 *
 */
public class Saludador {
	//atributos
	private String mensaje;
	
	//constructores (el primero es el constructor que te pone por defecto, si no pones constructor te pone ese)
	public Saludador() {
		super();
		this.mensaje = "Hola ";
	}
	
	public Saludador(String pMensaje) {
		this.mensaje = pMensaje;
	}
	
	//métodos
	
	public String saluda(String nombreUsuario) {
		return this.mensaje+nombreUsuario;
	}
	
	//sobrecargar el método (se puede definir el mismo método pero con diferentes argumentos
	
	public String saluda(){
		return this.mensaje+" Amigo";
	}
	
	

}
