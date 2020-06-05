package com.chaninfood.repositories;

import com.chaninfood.entities.CategoriaPlatillo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "categoriaPlatilloes", path = "categorias")
public interface CategoriaPlatilloRepositorio extends JpaRepository<CategoriaPlatillo, Long> {
}
