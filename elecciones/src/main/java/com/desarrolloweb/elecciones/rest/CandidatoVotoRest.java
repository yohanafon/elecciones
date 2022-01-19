package com.desarrolloweb.elecciones.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrolloweb.elecciones.annotations.isAdmin;
import com.desarrolloweb.elecciones.entities.CandidatoVoto;
import com.desarrolloweb.elecciones.security.services.ICandidatoVotoService;

@RestController
@RequestMapping("elecciones")
@isAdmin
public class CandidatoVotoRest {

	@Autowired
	private ICandidatoVotoService candidatovotoService;
	
	@Autowired
	private ModelMapper mapper;
	

	@PostMapping("/candidatovoto/crear")
	public CandidatoVoto crearCandidatoVoto(@RequestBody CandidatoVoto newCandidatoVoto) {
		return candidatovotoService.crearCandidatoVoto(newCandidatoVoto);
        }
	
}
