package com.desarrolloweb.elecciones.dtos;



import com.desarrolloweb.elecciones.entities.Tipo;

public class PersonaDTO {

	   private String cedula;

	    private Tipo tipo;

	    private String nombre;
	   
	    private String apellido;
	   
	    private String edad;

		public String getCedula() {
			return cedula;
		}

		public void setCedula(String cedula) {
			this.cedula = cedula;
		}

		public Tipo getTipo() {
			return tipo;
		}

		public void setTipo(Tipo tipo) {
			this.tipo = tipo;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getEdad() {
			return edad;
		}

		public void setEdad(String edad) {
			this.edad = edad;
		}
	
	    
}
