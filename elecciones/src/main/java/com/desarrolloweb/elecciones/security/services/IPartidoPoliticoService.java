package com.desarrolloweb.elecciones.security.services;

import java.util.Optional;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import com.desarrolloweb.elecciones.entities.PartidoPolitico;

public interface IPartidoPoliticoService {

	PartidoPolitico crearPartidoPolitico(PartidoPolitico PartidoPolitico);

	Page<PartidoPolitico> getPartidoPoliticos(Pageable pageable);

	Optional<PartidoPolitico> findByNombre(String nombre);

	void deletePartidoPolitico(String nombre);



}
