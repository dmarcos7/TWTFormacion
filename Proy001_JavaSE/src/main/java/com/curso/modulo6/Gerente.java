package com.curso.modulo6;

public class Gerente extends Empleado{
	
	//atributos = todos los del padre más los suyos
	private String depatamento;
	
	public Gerente() {
		
	}
	
	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return "Gerente Nombre: "+ this.getNombre()+" Salario: "+this.getSalario()
		+" Departamento: "+this.getDepatamento();
	}
	
	public String getDepatamento() {
		return depatamento;
	}
	
	public void setDepatamento(String depatamento) {
		this.depatamento = depatamento;
	}

}
