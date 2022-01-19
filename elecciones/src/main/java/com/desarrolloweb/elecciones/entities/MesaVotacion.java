package com.desarrolloweb.elecciones.entities;


import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * @author LenovoPC
 */

@Entity
public class MesaVotacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
   //@OneToMany 
    @ManyToOne
    Persona persona;
    
   @OneToMany( mappedBy="mesavotacion" )
    List<LocalVotacion> localvotaciones;
   
	@OneToMany( mappedBy="mesavotacion")
    private List<Boletin> boletines;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<LocalVotacion> getLocalvotaciones() {
		return localvotaciones;
	}

	public void setLocalvotaciones(List<LocalVotacion> localvotaciones) {
		this.localvotaciones = localvotaciones;
	}

	public List<Boletin> getBoletines() {
		return boletines;
	}

	public void setBoletines(List<Boletin> boletines) {
		this.boletines = boletines;
	}
	
   
}