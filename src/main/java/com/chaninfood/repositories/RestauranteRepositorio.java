package com.chaninfood.repositories;

import com.chaninfood.entities.Restaurante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface RestauranteRepositorio extends JpaRepository<Restaurante, Long> {

    Page<Restaurante> findByNombreContaining(@RequestParam("nombre") String nombre, Pageable pageable);
}
