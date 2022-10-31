package com.curso.springcore.ejemplo001;

import java.util.logging.Logger;

public class SaludoServiceImp implements SaludoService{

	Logger logger = Logger.getLogger("SaludoServiceImp");
	private String cabeceraMensaje;
	
	public SaludoServiceImp() {
		logger.info("...... INSTANCIANDO SERVICIO");
		this.cabeceraMensaje = "Hola";
	}
	
	
	public SaludoServiceImp(String mensaje) {
		logger.info("...... INSTANCIANDO SERVICIO");
		this.cabeceraMensaje = mensaje;
	}
	@Override
	public void saludar(String mensaje) {
		if(mensaje == null) {
			logger.severe("error gordo");
			throw new IllegalArgumentException("El mensaje vine a nulo");
		}
		logger.fine("mensaje " +mensaje);
		logger.info("saludo");
		
		
	}

}
