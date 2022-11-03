package com.curso.spring.repositorios;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.curso.spring.entidades.Pedido;

@Repository
public interface PedidoJPARepository extends JpaRepository<Pedido,Integer> {

	public static Logger log = LoggerFactory.getLogger(PedidoJPARepository.class);
	
	//añadir mas metodos
	
	@Query("SELECT p FROM Pedido p WHERE p.usuario=?1")
	public Collection<Pedido> getAllByUser(String userName);
	
	public List<Pedido> findByUsuario(String user);
	public List<Pedido> findByDescripcion(String descripcion);
	public List<Pedido> findByFechaPedido(String fechaPedido);
	
}
