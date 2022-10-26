package com.curso.jpa.pruebas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.jpa.entidades.Customer;
import com.curso.jpa.entidades.Orders;

public class PruebaOneToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1 crear la factoria de EM
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");

		// 2. CREAR EL EM
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		// crear un Pedido para un cliente
		Orders pedido = new Orders();
		Customer cliente = em.find(Customer.class, 6);
		pedido.setCliente(cliente);
		pedido.setDescripcion("MOVIDAS 2");
		// crear un cliente con ese recod
		// find del cliente que acabamos de crear
		// y buscar sus datos

		em.persist(pedido);
		em.getTransaction().commit();

		Orders o = em.find(Orders.class, 9);
		System.out.println(o.getDescripcion() + " Cliente: " + o.getCliente().getCustomerName());

		Customer cust = em.find(Customer.class, 6);
		
		System.out.println(cust.getCustomerName() + " lista de pedidos: " );
		for(Orders or:cust.getPedidos()) {
			System.out.println(or.getDescripcion());
		}
	}

}
