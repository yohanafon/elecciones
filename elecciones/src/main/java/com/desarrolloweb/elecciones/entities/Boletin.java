package com.desarrolloweb.elecciones.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Boletin {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	    
    @ManyToOne
    private CandidatoVoto candidatovoto;

   @ManyToOne
    private MesaVotacion mesavotacion;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public CandidatoVoto getCandidatovoto() {
	return candidatovoto;
}

public void setCandidatovoto(CandidatoVoto candidatovoto) {
	this.candidatovoto = candidatovoto;
}

public MesaVotacion getMesavotacion() {
	return mesavotacion;
}

public void setMesavotacion(MesaVotacion mesavotacion) {
	this.mesavotacion = mesavotacion;
}

	
}
