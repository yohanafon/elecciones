package com.desarrolloweb.elecciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrolloweb.elecciones.entities.Boletin;

@Repository()
public interface BoletinRepository extends JpaRepository<Boletin, Long>{

}
