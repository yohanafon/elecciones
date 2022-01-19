package com.desarrolloweb.elecciones.security.services;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

import com.desarrolloweb.elecciones.entities.Usuario;
import com.desarrolloweb.elecciones.repository.UsuarioRepository;


@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public UsuarioDetailsServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuarioOpt = usuarioRepository.findByNombreUsuario(username);
        if (usuarioOpt == null) {
        	throw new UsernameNotFoundException(String.format("El usuario con el nombre dado no existe %s", username));
        }
        List<SimpleGrantedAuthority> roles = getRoles(usuarioOpt);
        return new org.springframework.security.core.userdetails.User(usuarioOpt.getNombreUsuario(),
                usuarioOpt.getContraseña(),
                roles);
    }
	private List<SimpleGrantedAuthority> getRoles(Usuario usuario) {
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().getNombre()));

        return roles;
    }
	}
