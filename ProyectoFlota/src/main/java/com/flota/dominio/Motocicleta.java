package com.flota.dominio;

public class Motocicleta extends Vehiculo {

	public Motocicleta(String matricula, double cargaMaxima) {
		super(matricula, cargaMaxima);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double consumoFuel() {
		
		return 39.9;
	}
	
	@Override
	public void cargarCaja(Caja c) {
		if(this.getNumCajas() == 1) {
			throw new RuntimeException("La moto solo puede cargar una caja");
		}
		super.cargarCaja(c);
	}

}
