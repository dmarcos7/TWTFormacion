package com.curso.springcore.ejemplo002;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NominasServiceImp implements NominasService{
	//para inyecta en la variable de referencia irpf 
	//una instancia de IPFServiceImp
	@Autowired
	private IRPFService irpfService;
	@Override
	public void calcularNomina() {
		System.out.println("....... tu nomina es xxxxxx");
		System.out.println("Y el IRPF "+irpfService.calcularIRPF());
		
	}

}
