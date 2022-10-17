package com.curso.mercado.bd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.curso.mercado.entidades.Producto;

public class BaseDatosMercadoTest {

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
	public void insertarUnNuevoProductoDebeDevolverCount4() {
		int contadorEsperado = 4;
		BaseDatosMercado.getBaseDatosMercado().add(new Producto(4,"Camisa Amarilla", 5.9));
		
		assertEquals(BaseDatosMercado.getContador(), contadorEsperado);
		assertEquals(BaseDatosMercado.getBaseDatosMercado().solocitarPorId(4).getDescripcion(), "Camisa Amarilla");
		
	
	}

}
