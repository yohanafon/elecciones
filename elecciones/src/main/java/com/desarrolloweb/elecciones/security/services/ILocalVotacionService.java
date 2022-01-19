package com.desarrolloweb.elecciones.security.services;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.desarrolloweb.elecciones.entities.LocalVotacion;


public interface ILocalVotacionService {

	Page<LocalVotacion> getLocalVotaciones(Pageable pageable);

	LocalVotacion crearLocalVotacion(LocalVotacion LocalVotacion);

	void deleteLocalVotacion(Long id);

	Optional<LocalVotacion> findByCiudad(String ciudad);


}
