package com.example.storeJPA.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.storeJPA.model.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
	@Query(value="select p.* from pedidos p join pedidos_fabricantes fp on p.id = fp.pedidos where fp.fabricante = :id", 
			nativeQuery=true)
	Set<Pedido> findByFabricanteId(Integer id);

}
