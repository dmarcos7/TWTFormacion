package com.curso.Proy003_TresEnRaya;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TresEnRayaTest {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		TresEnRaya juego = new TresEnRaya();
		int n = 2;
		int n2 = 2;
		//resultado esperado
		int esperado = 4;
		//resultado real
		int r = juego.suma(n, n2);
		
		//si no coinciden fallo
		if(esperado != r) {
			fail("No ha sumado 2+2=4 sino que el resultado es: "+r);
		}
	}
	
	@Test
	public void sumarDosMasDosDara4() {
		//datos entra
		TresEnRaya juego = new TresEnRaya();
		int n = 2;
		int n2 = 2;
		//resultado esperado
		int esperado = 4;
		//resultado real
		int r = juego.suma(n, n2);
		
		//si no coinciden fallo
		if(esperado != r) {
			fail("No ha sumado 2+2=4 sino que el resultado es: "+r);
		}
		
	}
	
	@Test(expected = RuntimeException.class)
	public void ponerFichaEnCoordenadaXMal() {
		
		TresEnRaya juego = new TresEnRaya();
		
		//tres filas y tres columnas (0 a 2)
		juego.jugar(4,2); // falla si no lanza un runtimeexception
		
	}

	@Test(expected = RuntimeException.class)
	public void ponerFichaEnCoordenadaYMal() {
		
		TresEnRaya juego = new TresEnRaya();
		
		//tres filas y tres columnas (0 a 2)
		juego.jugar(2,4); // falla si no lanza un runtimeexception
		
	}
	
	@Test(expected = RuntimeException.class)
	public void ponerFichaEnPosicionOcupadaLanzaUnaExcepcion() {
		
		//preparar el escenario. Poner el tablero con una ficha en esa posicion
		
		TresEnRaya juego = new TresEnRaya();
		juego.jugar(0, 0);
		
		juego.jugar(0, 0);
		
		
	}
	
	@Test
	public void ponerFichaBien() {
		TresEnRaya juego = new TresEnRaya();
		juego.jugar(0, 0);
		if(juego.getFicha(0,0)==null) {
			fail("No se ha colocado la ficha en la posicion correcta");
		}
	}
	
	@Test
	public void primerJugadorEsX() {
		TresEnRaya juego = new TresEnRaya();
		
		
		if(juego.getJugadorActual() != 'x') {
			fail("El primer Jugador debe ser X ");
		}
		//juego.jugar(0, 0);
	}
	
	@Test
	public void anteriorJugadorXAhoraO() {
		TresEnRaya juego = new TresEnRaya();
		juego.jugar(0, 0);
		
		if(juego.getJugadorActual() != 'o') {
			fail("El primer Jugador debe ser X ");
		}
		
	}
	
	@Test
	public void anteriorJugadorOAhoraX() {
		TresEnRaya juego = new TresEnRaya();
		juego.jugar(0, 0);
		juego.jugar(0, 2);
		
		if(juego.getJugadorActual() != 'x') {
			fail("El primer Jugador debe ser X ");
		}
		
	}
	
	@Test 
	public void comprobarTresIgualesHorizontalX() {
		TresEnRaya juego = new TresEnRaya();
		juego.jugar(0, 0);
		juego.jugar(0, 1);
		juego.jugar(1, 0);
		juego.jugar(0, 2);
		juego.jugar(2, 0);
		
		if(juego.comprobarGanador()== 'x') {
			
		}
	}
	
	@Test 
	public void comprobarTresIgualesHorizontalY() {
		TresEnRaya juego = new TresEnRaya();
		juego.jugar(0, 0);
		juego.jugar(0, 1);
		juego.jugar(1, 0);
		juego.jugar(0, 2);
		juego.jugar(2, 0);
		
		if(juego.comprobarGanador()== 'x') {
			
		}
	}
	
	@Test
	public void comprobarTresIgualesVertical() {
		
	}
	
	@Test
	public void comprobarTresIgualesDiagonal() {
		
	}
	
	
}
