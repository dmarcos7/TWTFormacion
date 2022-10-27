package com.curso.jpa.pruebas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.curso.jpa.entidades.Departamento;

public class PruebasCriteria {

	public static void main(String[] args) {
		// 1. Usando criteria builder
		// obtener todos los departamentos
		// por localidad or manager
		// condicion localidad y manager es opcional
		//si no me pasas localidad ni manager paso todos

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();

		Integer localidad = 1700;
		Integer manager = 3;

		CriteriaBuilder cb = em.getCriteriaBuilder();
		//aqui se crea la Select * from departamento
		CriteriaQuery<Departamento> cq = cb.createQuery(Departamento.class);

		//esto seria la select
		Root<Departamento> from = cq.from(Departamento.class);
		//List<Predicate> condiciones = new ArrayList<>();
		Predicate localidadPred = null;
		Predicate condicionFinal = null;
		Predicate managerPred = null;
		// si me has pasado un nombre de empleado lo añado en el where
		if (localidad != null && manager!=null) {
			//los predicados son las condiciones del WHERE
			localidadPred = cb.equal(from.get("idLocalidad"), localidad);
			managerPred =cb.equal(from.get("idManager"), manager);
			condicionFinal = cb.or(localidadPred, managerPred);
		}else if(localidad!=null && manager==null) {
			condicionFinal = cb.equal(from.get("idLocalidad"), localidad);
		}else if(manager!=null) {
			condicionFinal = cb.equal(from.get("idManager"), manager);
		}
		
		if(condicionFinal!=null) {
			cq.where(condicionFinal);
		}
		

		Query qCriteria = em.createQuery(cq);
		List<Departamento> listaDepartamentos = qCriteria.getResultList();
		System.out.println("Lista empleados ");
		for (Departamento e : listaDepartamentos) {
			System.out.println(e);
		}

	}

}
