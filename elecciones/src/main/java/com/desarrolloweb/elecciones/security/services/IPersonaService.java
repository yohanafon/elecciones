package com.desarrolloweb.elecciones.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import com.desarrolloweb.elecciones.entities.Persona;



public interface IPersonaService {
	
	void deletePersona(Long cedula);
	
	Persona crearPersona(Persona newPersona);

	Optional<Persona> findByCedula(Long cedula);
	
	 Persona save(Persona persona);

	List<Persona> findAll();

	Page<Persona> getPersonas(Pageable pageable);

	Persona actualizarPersona(Persona Persona, Long cedula);



	
	
}
