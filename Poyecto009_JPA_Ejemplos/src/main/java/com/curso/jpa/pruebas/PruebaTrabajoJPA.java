package com.curso.jpa.pruebas;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.jpa.entidades.Trabajo;

public class PruebaTrabajoJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Factoria de EntityManager
		
		//equivalente al getconnection
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("OracleHRPU");
		
		//2. obtenemos un Entity Manager
		//que conecta con HR DE ORACLE y mapea las calses entidad 
		//que estan en el persistence.xml
		
		EntityManager em = factory.createEntityManager();
		
		//3. Obtener el trabajo con el id "AD_VP"
		Trabajo t = em.find(Trabajo.class, "AD_VP");
		System.out.println(t);
		
		//4. crear un nuevo trabajo
		Trabajo tNuevo = new Trabajo("BE_OL", "Tareas Super dificiles", 33000.0,53000.0);
		//inicia una nueva transaccion
		em.getTransaction().begin();
		
		em.persist(tNuevo);
		//obtiene la transaccion y la confirma
		em.getTransaction().commit();
		
		//5. MODO 1. Modificar despues de un find
		//Esto es una copia
		Trabajo tNuevoModif = new Trabajo("BE_OL", "Tareas Super dificil de verdad", 33000.0,53000.0);
		
		try {
			em.getTransaction().begin();
			Trabajo tDesdeBD = em.find(Trabajo.class, tNuevoModif.getId());
			
			tDesdeBD.setTituloTabajo(tNuevoModif.getTituloTabajo());
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			
		}
		
		//5. MODO 2. Usando el método em.merge
		Trabajo tNuevoModif2 = new Trabajo("BE_OL", "Tareas Super dificil de verdad *", 38000.0,553000.0);
		em.getTransaction().begin();
		Trabajo trabajoEnBD = em.merge(tNuevoModif2);
		//tNuevoModif no esa attached contra BD
		tNuevoModif2.setTituloTabajo("adasdasfasda");
		trabajoEnBD.setTituloTabajo("Este si está attached");
		em.getTransaction().commit(); //update
		
		
		//6. Borrar
		
		em.getTransaction().begin();
		Trabajo tABorrar = new Trabajo();
		tABorrar.setId("BE_OL");
		
		
		//find del objeto
		Trabajo tBD = em.find(Trabajo.class, tABorrar.getId());
		//tbd esta sincronizado
		//remove
		em.remove(tBD);
		em.getTransaction().commit();
		
		// 7. Consulta JPA QUERY
		Query query = em.createQuery("SELECT t FROM TRABAJO t");
		
		Collection<Trabajo> lista  = query.getResultList();
		for(Trabajo trabajo: lista) {
			System.out.println(trabajo);
		}
		
	}

}
