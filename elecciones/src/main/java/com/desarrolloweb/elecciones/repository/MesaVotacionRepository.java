package com.desarrolloweb.elecciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrolloweb.elecciones.entities.MesaVotacion;

@Repository()
public interface MesaVotacionRepository extends JpaRepository<MesaVotacion, Long>{

}
