package com.desarrolloweb.elecciones.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrolloweb.elecciones.entities.LocalVotacion;



@Repository()
public interface LocalVotacionRepository extends JpaRepository<LocalVotacion, Long>{

	Optional<LocalVotacion> findByCiudad(String ciudad);

}
