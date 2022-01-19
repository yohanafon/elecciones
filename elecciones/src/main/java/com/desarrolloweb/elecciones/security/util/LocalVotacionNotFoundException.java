package com.desarrolloweb.elecciones.security.util;

@SuppressWarnings("serial")
public class LocalVotacionNotFoundException  extends RuntimeException{

	public LocalVotacionNotFoundException(Long id) {
		super("No se pudo encontrar el local de votacion con el id: " + id);
	}
}
