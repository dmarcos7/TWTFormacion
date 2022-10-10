package com.curso.modulo6;

public class Director extends Gerente {
	private double vehiculoEmpresa;
	
	public Director() {
		
	}
	
	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		
		return "Director Nombre: "+this.getNombre()+" Salario: "+this.getSalario()
		+" Departamento: "+this.getDepatamento()+" Vehiculo Empresa: "+this.getVehiculoEmpresa();
	}
	
	public void aumentarComision() {
		
	}
	
	public double getVehiculoEmpresa() {
		return vehiculoEmpresa;
	}
}
