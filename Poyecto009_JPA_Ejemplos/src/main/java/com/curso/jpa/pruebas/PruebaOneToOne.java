package com.curso.jpa.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.curso.jpa.entidades.*;
import com.curso.jpa.entidades.Record;


public class PruebaOneToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 crear la factoria de EM
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");

		// 2. CREAR EL EM
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		//crear un record
		//crear un cliente con ese recod
		//find del cliente que acabamos de crear
		//y buscar sus datos
		
		
		Record rec = new Record(null, "REC UNO");
		em.persist(rec);
		
		
		
		Customer cliente = new Customer(null,"David",rec);
		em.persist(cliente);
		int id = cliente.getId();
		em.getTransaction().commit();
		
		Customer nuevoCliente = em.find(Customer.class, id);
		
		System.out.println(nuevoCliente + "RECORD: "+nuevoCliente.getRecord());

	}

}
