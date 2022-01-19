package com.desarrolloweb.elecciones.repository;



import org.springframework.data.repository.CrudRepository;

import com.desarrolloweb.elecciones.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Usuario findByNombreUsuario(String username);
}
