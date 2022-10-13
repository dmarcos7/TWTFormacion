package com.mymaquina.ejercicio2.pruebas;

import com.mymaquina.ejercicio2.entidades.Maquina;
import com.mymaquina.ejercicio2.entidades.Refresco;

public class PruebasMaquina {

	public static void main(String[] args) {
		
		//Se crea la máquina con un numero de monedas dentro (no está implementado el tipo de monedas que devuelve)
		// de momento el cliente introduce la cantidad en centimos
		
		Maquina maquina = Maquina.getMaquina();
		
		// se repone la máquina de refrescos porque inicialmente se encuentra vacia
		// De momento solo un tipo de refresco para que la inicializacion de las pruebas no sea muy larga, se irá aumentando
		
		try {
			Refresco r = new Refresco(0, "Naranja", 25.0, 80.0, false, 0);
			maquina.anadirRefresco(r);
			maquina.reponer(r, 20);
			
			// se sustituirá por un método de meter monedas
			maquina.vender(0, 0.80);
			
			maquina.mostrarInforme();
			
			//no se introduce dinero
			//maquina.vender(0, 0);
			
			maquina.vender(1, 0);
			
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
