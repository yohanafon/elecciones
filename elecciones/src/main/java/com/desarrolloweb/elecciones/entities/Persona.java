package com.desarrolloweb.elecciones.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;




@Entity
public class Persona {

    @Id
    private Long cedula;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Basic
    private String nombre;
    @Basic
    private String apellido;
    @Basic
    private String edad;
    
    @OneToMany(mappedBy = "persona")
    List<MesaVotacion> mesaVotacion;

    @OneToMany(mappedBy = "persona")
  List<PartidoPolitico> partidoPolitico;

    
	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
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

	public List<MesaVotacion> getMesaVotacion() {
		return mesaVotacion;
	}

	public void setMesaVotacion(List<MesaVotacion> mesaVotacion) {
		this.mesaVotacion = mesaVotacion;
	}

	
	

	

	public List<PartidoPolitico> getPartidoPolitico() {
		return partidoPolitico;
	}

	public void setPartidoPolitico(List<PartidoPolitico> partidoPolitico) {
		this.partidoPolitico = partidoPolitico;
	}

	
   
}