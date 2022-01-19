package com.desarrolloweb.elecciones.security.util;

@SuppressWarnings("serial")
public class PartidoPoliticoNotFoundException extends RuntimeException {
	public  PartidoPoliticoNotFoundException (String nombre) {
		super("No se pudo encontrar el partido politico con el nombre:" + nombre);
	
	}
}



