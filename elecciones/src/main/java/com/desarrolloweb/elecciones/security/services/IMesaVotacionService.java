package com.desarrolloweb.elecciones.security.services;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import com.desarrolloweb.elecciones.entities.MesaVotacion;

public interface IMesaVotacionService {

	Page<MesaVotacion> getMesaVotaciones(Pageable Pageable);

	MesaVotacion crearMesaVotacion(MesaVotacion newMesaVotacion);

	void deleteMesaVotacion(Long id);

}
