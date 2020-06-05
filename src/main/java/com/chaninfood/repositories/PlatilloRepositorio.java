package com.chaninfood.repositories;

import com.chaninfood.entities.Platillo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(collectionResourceRel = "platilloes", path = "platillos")
public interface PlatilloRepositorio extends JpaRepository<Platillo, Long> {
    Page<Platillo> getPlatillosByCategoriaId(@RequestParam("id") Long id, Pageable pageable);
    Page<Platillo> findByNombreContainingAndCategoriaId(@RequestParam("nombre") String nombre, @RequestParam("id") Long id, Pageable pageable);
}