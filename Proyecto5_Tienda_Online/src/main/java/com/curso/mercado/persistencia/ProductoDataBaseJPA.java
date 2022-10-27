package com.curso.mercado.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.mercado.entidades.Producto;

public class ProductoDataBaseJPA implements GenericDAO<Producto> {

	@Override
	public void add(Producto entidad) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(entidad);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Producto> getAll() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("SELECT p FROM PRODUCTO p");
		List<Producto> lista  = q.getResultList();
		return lista;
	}

	@Override
	public Producto getByID(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();
		Producto p = null;
		try {
			em.getTransaction().begin();
			p = em.find(Producto.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			em.getTransaction().rollback();
		}
		return p;
	}

	@Override
	public void delete(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		
		//find del objeto
		Producto producto = em.find(Producto.class, id);
		//tbd esta sincronizado
		//remove
		em.remove(producto);
		em.getTransaction().commit();
		
	}

	@Override
	public void update(Producto entidad) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Producto producto = em.merge(entidad);
		em.getTransaction().commit();
		
		
		
	}

}
