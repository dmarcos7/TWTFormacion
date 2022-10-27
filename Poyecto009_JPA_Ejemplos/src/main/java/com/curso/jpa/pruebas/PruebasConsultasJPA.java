package com.curso.jpa.pruebas;

import java.util.ArrayList;
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
import com.curso.jpa.entidades.Empleado;

public class PruebasConsultasJPA {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();
		
		//QUERY NATIVA (BD) => select * from departments
		//JPA QUERY => SELECT d FROM Departamento d;
		
		
		//MODO 1 Hay que utilizar los nombres de las clases de 
		Query consulta = em.createQuery("SELECT d "
				+ "FROM Departamento d "
				+ "WHERE d.idManager IS NULL");
		List <Departamento> lista = consulta.getResultList();
		System.out.println("Lista de departamentos");
		for(Departamento d2: lista) {
			System.out.println(d2);
		}
		
		//MODO 2 -NAMED QUERYS
		Query consulta2 = em.createNamedQuery("Departamento.findAll"); //el nombre de la consulta está en la clase departamento en este caso
		List <Departamento> lista2 = consulta2.getResultList();
		System.out.println("Lista de TODOS los departamentos");
		for(Departamento d2: lista2) {
			System.out.println(d2);
		}
		
		//MODO 3 - QUERIES NATIVAS
		Query consulta3 = em.createNativeQuery("SELECT * FROM DEPARTMENTS", Departamento.class);
		List <Departamento> lista3 = consulta3.getResultList();
		System.out.println("Lista de TODOS los departamentos");
		for(Departamento d2: lista3) {
			System.out.println(d2);
		}
		
		//CONSULTA CON PARAMETROS
		Query qConParam = em.createNamedQuery("Departamento.findByManager");
		qConParam.setParameter("idManager", 108);
		
		List<Departamento> departamentos108 = qConParam.getResultList();
		System.out.println("Los departamentos del manager 108 son: ");
		for(Departamento d2: departamentos108) {
			System.out.println(d2);
		}
		
		/*
		 * select d.department_id, d.department_name, e.first_name, e.last_name from
		 * departments d inner join employees e on d.manager_id = e.employee_id;

		 */
		
		//Las join las hace implicitas
		
		String consultaEmpleadoDptoLoc1700 =
				"SELECT e  FROM Empleado e "
				+ "WHERE e.departamento.idLocalidad = :idLoc";
		int idLoc = 1700;
		
		Query q = em.createQuery(consultaEmpleadoDptoLoc1700);
		q.setParameter("idLoc", idLoc);
		List<Empleado> listEmp = q.getResultList();
		System.out.println("Lista de empleados depart localidad 1700");
		
		for(Empleado e: listEmp) {
			System.out.println(e);
		}
		
		//CRITERIA
		
		//PANTALLA Filtro busqueda / lista resultado de la busqueda
		
		//filtro NOMBRE
		//filtro ID TRABAJO
		//...
		
		String nombre ="Steven";
		String apellido="King";
		Integer idJob=null;
		
		CriteriaBuilder cb=  em.getCriteriaBuilder();
		
		//Enidades que quiero recuperar
		CriteriaQuery cq = cb.createQuery(Empleado.class);
		
		//FROM
		Root<Empleado> from = cq.from(Empleado.class);
		
		//objeto Predicate que va montando las condiciones del where
		Predicate miWhere = null;
		List<Predicate> condiciones = new ArrayList<>();
		Predicate predicateNombre;
		Predicate predicateApellido;
		// si me has pasado un nombre de empleado lo añado en el where
		if(nombre != null) {
			condiciones.add(cb.equal(from.get("nombre"), nombre));
		}
		
		if(apellido!=null) {
			condiciones.add(cb.equal(from.get("apellidos"), apellido));
			
		}
		
		//OR JOBID='AD_ASST'
		Predicate andVaios = cb.and(condiciones.toArray(new Predicate[0]));
		Predicate orJob = cb.equal(from.get("idTrabajo"), "AD_ASST");
		Predicate whereFinal = cb.or(andVaios, orJob);
		cq.where(whereFinal);
		
		//WHERE
//		if(condiciones.size()>0) {
//			//ArrayList to Array
//			Predicate [] condicionesFinal = new Predicate[condiciones.size()];
//			condiciones.toArray(condicionesFinal);
//			cq.where(condiciones.toArray(new Predicate[0]));
//		}
		
		//Ejecutar la consulta
		Query qCriteria = em.createQuery(cq);
		List<Empleado> listaEmpleados = qCriteria.getResultList();
		System.out.println("Lista empleados ");
		for (Empleado e : listaEmpleados) {
			System.out.println(e);
		}
	}
	
	
	

}
