package com.desarrolloweb.elecciones.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.desarrolloweb.elecciones.entities.LocalVotacion;
import com.desarrolloweb.elecciones.repository.LocalVotacionRepository;
import com.desarrolloweb.elecciones.security.util.LocalVotacionNotFoundException;



@Service
public class LocalVotacionService implements ILocalVotacionService{

	@Autowired
	private LocalVotacionRepository localvotacionrepository;
	
	@Override
	public Page<LocalVotacion> getLocalVotaciones(Pageable pageable) {
		return localvotacionrepository.findAll(pageable);
	}

	@Override
	public LocalVotacion crearLocalVotacion(LocalVotacion newLocalVotacion) {
		return localvotacionrepository.save(newLocalVotacion);
	}
	
	@Override
	public void deleteLocalVotacion(Long id) {
		Optional<LocalVotacion> localvotacion = localvotacionrepository.findById(id);


		if (localvotacion.isPresent()) {
			localvotacionrepository.delete(localvotacion.get());
		} else {
			throw new LocalVotacionNotFoundException(id);
		}
	}

	@Override
	public Optional<LocalVotacion> findByCiudad(String ciudad) {
		return localvotacionrepository.findByCiudad(ciudad);
	}


	
}
