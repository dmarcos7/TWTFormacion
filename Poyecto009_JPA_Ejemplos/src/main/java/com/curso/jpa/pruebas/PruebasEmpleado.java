package com.curso.jpa.pruebas;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.jpa.entidades.Empleado;

public class PruebasEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1 crear la factoria de EM
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		
		//2. CREAR EL EM
		EntityManager em = factory.createEntityManager();
		
		//3. CREAR UNA TRANSACCION
		
		
		try {
			em.getTransaction().begin();
			
			//4. CREAR EMPLEADO NUEVO Y PERSISTIR EN BD
			Empleado e = new Empleado(null, "David", "Marcos");
			e.setEmail("email1@email.com");
			e.setFechaContratacion(new java.util.Date());
			e.setIdTrabajo("AD_VP");
			e.setSalario(10000.0);
			em.persist(e);
			
			em.getTransaction().commit();
			System.out.println("COMMIT!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			//5. CONFIRMAR TRANSACCION SI OK, ROLLBACK SI FALLO
		} catch (Exception e) {
			
			em.getTransaction().rollback();
			System.out.println("ROLLBACK!!!!!!!!!!!!!!!!!!!!!");
		}
		
		
		

	}

}
