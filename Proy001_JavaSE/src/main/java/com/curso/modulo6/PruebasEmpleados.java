package com.curso.modulo6;

public class PruebasEmpleados {

	public static void main(String[] args) {
		Empleado  e = new Empleado();
		e.setNombre("Luis Ramos");
		e.setSalario(40000);
		
		Gerente g = new Gerente();
		g.setNombre("Begoña Olea");
		g.setDepatamento("Desarrollo");
		g.setSalario(70000);
		
		System.out.println("g es un gerente? "+ (g instanceof Gerente));
		
		System.out.println("g es un empleado? "+ (g instanceof Empleado));

		System.out.println("e es un gerente? "+ (e instanceof Gerente));
		
		System.out.println("e es un empleado? "+ (e instanceof Empleado));
	
	
		//Una variable de referencia puede apuntar
		//a objetos de su clase o clases hijas
		
		Empleado carlos = new Gerente();
		carlos.setNombre("Carlos Romero");
		carlos.setSalario(45000);
		//carlos.setDepartamento("....");
		
		// Carlos tiene forma de empleado por lo tanto solo puede
		// acceder a los metodos declarados en la clase empleado 
	}

}
