package com.desarrolloweb.elecciones.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrolloweb.elecciones.annotations.isAdmin;
import com.desarrolloweb.elecciones.dtos.LocalVotacionDTO;
import com.desarrolloweb.elecciones.entities.LocalVotacion;
import com.desarrolloweb.elecciones.security.services.ILocalVotacionService;

@RestController
@RequestMapping("elecciones")
@isAdmin
public class LocalVotacionRest {

	@Autowired
	private ILocalVotacionService localvotacionService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/localvotacion/{page}/{size}")
	public List<LocalVotacionDTO> getLocalVotaciones(@PathVariable("page") int page, @PathVariable("size") int size) {
		
		Page<LocalVotacion> localvotaciones = localvotacionService.getLocalVotaciones(PageRequest.of(page, size));

		
		List<LocalVotacionDTO> result = new ArrayList<>();
		
		for (LocalVotacion localvotacion : localvotaciones) {
			result.add(mapper.map(localvotacion, LocalVotacionDTO.class));
	
		}
		return result; 	
		}
	
	@PostMapping("/localvotacion/crear")
	public LocalVotacion crearLocalVotacion(@RequestBody LocalVotacion newLocalVotacion) {
		return localvotacionService.crearLocalVotacion(newLocalVotacion);
        }
	
	@DeleteMapping("/localvotacion/eliminar/{id}")
	public void deleteLocalVotacion(@PathVariable Long id) {
		localvotacionService.deleteLocalVotacion(id);	
	}
	
	@GetMapping("/local/consultar/{ciudad}")
	public Optional<LocalVotacion> findByCiudad(@PathVariable String ciudad) {
		return localvotacionService.findByCiudad(ciudad);	
	}
	
	
	
}
