package com.desarrolloweb.elecciones.security.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.desarrolloweb.elecciones.entities.PartidoPolitico;
import com.desarrolloweb.elecciones.repository.PartidoPoliticoRepository;
import com.desarrolloweb.elecciones.security.util.PartidoPoliticoNotFoundException;



@Service
public class PartidoPoliticoService implements IPartidoPoliticoService{

	@Autowired
	private PartidoPoliticoRepository partidopoliticorepository;
	
	@Override
	public PartidoPolitico crearPartidoPolitico(PartidoPolitico newPartidoPolitico) {
		return partidopoliticorepository.save(newPartidoPolitico);
	}

	@Override
	public Page<PartidoPolitico> getPartidoPoliticos(Pageable pageable) {
	
		return partidopoliticorepository.findAll(pageable);
	}

	@Override
	public Optional<PartidoPolitico> findByNombre(String nombre) {
		return partidopoliticorepository.findByNombre(nombre);
	}

	@Override
	public void deletePartidoPolitico(String nombre) {
		Optional<PartidoPolitico> partidopolitico = partidopoliticorepository.findByNombre(nombre);


		if (partidopolitico.isPresent()) {
			partidopoliticorepository.delete(partidopolitico.get());
		} else {
			throw new PartidoPoliticoNotFoundException(nombre);
		}
		
	}
	

//Persona persona = PersonaService.findByCedula(partidopolitico.getPersona().getCedula());
// partidopolitico.setPersona(persona);
}