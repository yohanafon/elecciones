package com.desarrolloweb.elecciones.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrolloweb.elecciones.entities.CandidatoVoto;
import com.desarrolloweb.elecciones.repository.CandidatoVotoRepository;


@Service
public class CandidatoVotoService implements ICandidatoVotoService{

	@Autowired
	private CandidatoVotoRepository candidatovotorepository;
	
	@Override
	public CandidatoVoto crearCandidatoVoto(CandidatoVoto newCandidatoVoto) {
		return candidatovotorepository.save(newCandidatoVoto);
	}

}
