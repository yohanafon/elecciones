package com.desarrolloweb.elecciones.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.desarrolloweb.elecciones.entities.MesaVotacion;
import com.desarrolloweb.elecciones.entities.Persona;
import com.desarrolloweb.elecciones.repository.MesaVotacionRepository;
import com.desarrolloweb.elecciones.security.util.MesaVotacionNotFoundException;
import com.desarrolloweb.elecciones.security.util.PersonaNotFoundException;



@Service
public class MesaVotacionService implements IMesaVotacionService{

	@Autowired
	private MesaVotacionRepository mesavotacionrepository;
	
	@Override
	public Page<MesaVotacion> getMesaVotaciones(Pageable pageable) {
		return mesavotacionrepository.findAll(pageable);
	}


	
	@Override
	public void deleteMesaVotacion(Long id) {
		Optional<MesaVotacion> mesavotacion = mesavotacionrepository.findById(id);


		if (mesavotacion.isPresent()) {
			mesavotacionrepository.delete(mesavotacion.get());
		} else {
			throw new MesaVotacionNotFoundException(id);
		}
		
	}



	@Override
	public MesaVotacion crearMesaVotacion(MesaVotacion newMesaVotacion) {
		return mesavotacionrepository.save(newMesaVotacion);
	}
}

