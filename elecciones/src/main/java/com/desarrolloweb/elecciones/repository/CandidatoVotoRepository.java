package com.desarrolloweb.elecciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrolloweb.elecciones.entities.CandidatoVoto;



@Repository()
public interface CandidatoVotoRepository  extends JpaRepository<CandidatoVoto, Long>{

}
