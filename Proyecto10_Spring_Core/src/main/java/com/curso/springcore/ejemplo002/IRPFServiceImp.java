package com.curso.springcore.ejemplo002;

import org.springframework.stereotype.Service;

@Service
public class IRPFServiceImp implements IRPFService{

	@Override
	public double calcularIRPF() {
		
		return 10;
	}

}
