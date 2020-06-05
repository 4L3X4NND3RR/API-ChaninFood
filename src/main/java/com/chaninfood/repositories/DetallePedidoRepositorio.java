package com.chaninfood.repositories;

import com.chaninfood.entities.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "detallePedidoes", path = "detallePedidos")
public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, Long> {

    @Query("select t from DetallePedido t where t.pedido.id = :#{#idPedido}")
    List<DetallePedido> findByPedidoId(@RequestParam("idPedido") Long idPedido);
}
