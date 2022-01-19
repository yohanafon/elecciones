package com.desarrolloweb.elecciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desarrolloweb.elecciones.security.model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}

