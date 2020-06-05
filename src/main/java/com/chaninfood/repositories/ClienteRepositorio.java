package com.chaninfood.repositories;

import com.chaninfood.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, String>  {
}
