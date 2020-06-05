package com.chaninfood.repositories;

import com.chaninfood.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@RepositoryRestResource(collectionResourceRel = "pedidoes", path = "pedidos")
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

    @Query("select p from Pedido p where p.restaurante.id = :#{#id} and p.fecha > :#{#fecha} and p.entregado = :#{#entregado}")
    Page<Pedido> findByRestauranteIdAndFechaGreaterThanAndEntregado(@RequestParam("id") Long id, @RequestParam("fecha") Date fecha, @RequestParam("entregado") boolean entregado, Pageable pageable);
}
