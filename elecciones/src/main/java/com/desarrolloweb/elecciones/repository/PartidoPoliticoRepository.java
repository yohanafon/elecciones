package com.desarrolloweb.elecciones.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrolloweb.elecciones.entities.PartidoPolitico;



@Repository()
public interface PartidoPoliticoRepository extends JpaRepository<PartidoPolitico, Long> {

	Optional<PartidoPolitico> findByNombre(String nombre);
	
	

}
