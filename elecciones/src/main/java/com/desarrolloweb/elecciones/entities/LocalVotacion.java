package com.desarrolloweb.elecciones.entities;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author LenovoPC
 */

@Entity
public class LocalVotacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String nombre;
    @Basic
    private String ciudad;
    @ManyToOne
    private MesaVotacion mesavotacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

	public MesaVotacion getMesavotacion() {
		return mesavotacion;
	}

	public void setMesavotacion(MesaVotacion mesavotacion) {
		this.mesavotacion = mesavotacion;
	}

  

    

}