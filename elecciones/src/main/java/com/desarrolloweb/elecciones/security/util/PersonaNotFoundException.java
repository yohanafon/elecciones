package com.desarrolloweb.elecciones.security.util;


@SuppressWarnings("serial")
public class PersonaNotFoundException extends RuntimeException {

	
	public PersonaNotFoundException(Long cedula) {
		super("No se pudo encontrar la persona con cédula:" + cedula);
	}
}
