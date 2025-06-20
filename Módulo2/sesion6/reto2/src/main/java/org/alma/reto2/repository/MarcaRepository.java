package org.alma.reto2.repository;


import org.alma.reto2.model.Marca; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
