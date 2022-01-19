package com.desarrolloweb.elecciones.security.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.desarrolloweb.elecciones.entities.Usuario;

@Entity
public class Role {
     
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  id;
	private String nombre;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="rol")
	private List<Usuario> usuarios;
	
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
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
