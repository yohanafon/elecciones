package com.desarrolloweb.elecciones.entities;



import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class CandidatoVoto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String cantidad;
	
	@OneToOne
    private Persona persona;
	
	@OneToMany(mappedBy="candidatovoto")
    private List<Boletin> boletines;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Boletin> getBoletines() {
		return boletines;
	}

	public void setBoletines(List<Boletin> boletines) {
		this.boletines = boletines;
	}


}
