package com.desarrolloweb.elecciones.security.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.desarrolloweb.elecciones.entities.Persona;
import com.desarrolloweb.elecciones.repository.PersonaRepository;
import com.desarrolloweb.elecciones.security.util.PersonaNotFoundException;



@Service
public class PersonaService implements IPersonaService{

	
	
	@Autowired
	private PersonaRepository personarepository;
	

	
	@Override
	public Persona crearPersona(Persona newPersona) {
		return personarepository.save(newPersona);
	}

	@Override
	public List<Persona> findAll() {
		return (List<Persona>) personarepository.findAll();
	}
	
	@Override
	public Page<Persona> getPersonas(Pageable pageable) {
		return personarepository.findAll(pageable);
	}

	@Override
	public void deletePersona(Long cedula) {
		Optional<Persona> persona = personarepository.findByCedula(cedula);


		if (persona.isPresent()) {
			personarepository.delete(persona.get());
		} else {
			throw new PersonaNotFoundException(cedula);
		}
		
	}


	
	@Override
	public Optional<Persona>  findByCedula(Long cedula) {
		return personarepository.findByCedula(cedula);
	}

	@Override
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona actualizarPersona(Persona newPersona, Long cedula) {

		return personarepository.findByCedula(cedula).map(provider -> {
			provider.setCedula(newPersona.getCedula());
			provider.setTipo(newPersona.getTipo());
			provider.setNombre(newPersona.getNombre());
			provider.setApellido(newPersona.getApellido());
			provider.setEdad(newPersona.getEdad());
			
			return personarepository.save(provider);
		}).orElseGet(() -> {
			throw new PersonaNotFoundException(cedula);
		});
	}
	
}
