package com.desarrolloweb.elecciones.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.desarrolloweb.elecciones.entities.Persona;



@Repository()
public interface PersonaRepository extends JpaRepository<Persona, String> {

	Optional<Persona> findByCedula(Long cedula);

	


	

	



	
	

}
