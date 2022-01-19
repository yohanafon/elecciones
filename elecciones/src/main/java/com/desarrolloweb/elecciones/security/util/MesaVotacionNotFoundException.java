package com.desarrolloweb.elecciones.security.util;


@SuppressWarnings("serial")
public class MesaVotacionNotFoundException extends RuntimeException {
	public MesaVotacionNotFoundException(Long id) {
		super("No se pudo encontrar la mesa de votacion con el id: " + id);
	}
}






	


