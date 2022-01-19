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
import com.desarrolloweb.elecciones.dtos.PartidoPoliticoDTO;
import com.desarrolloweb.elecciones.entities.PartidoPolitico;
import com.desarrolloweb.elecciones.security.services.IPartidoPoliticoService;

@RestController
@RequestMapping("elecciones")
@isAdmin
public class PartidoPoliticoRest {

	@Autowired
	private IPartidoPoliticoService partidopoliticoService;
	
	@Autowired
	private ModelMapper mapper;
	
		@GetMapping("/partidospoliticos/{page}/{size}")
		public List<PartidoPoliticoDTO> getPartidoPoliticos(@PathVariable("page") int page, @PathVariable("size") int size) {
			
			Page<PartidoPolitico> partidopoliticos = partidopoliticoService.getPartidoPoliticos(PageRequest.of(page, size));

			
			List<PartidoPoliticoDTO> result = new ArrayList<>();
			
			for (PartidoPolitico partidopolitico : partidopoliticos) {
				result.add(mapper.map(partidopolitico, PartidoPoliticoDTO.class));
			}
			return result; 	
			}
		
		@PostMapping("/partidopolitico/crear")
		public PartidoPolitico crearPartidoPolitico(@RequestBody PartidoPolitico newPartidoPolitico) {
			return partidopoliticoService.crearPartidoPolitico(newPartidoPolitico);
	        }
		
		@GetMapping("/partidopolitico/consultar/{nombre}")
		public Optional<PartidoPolitico> findByNombre(@PathVariable String nombre) {
			return partidopoliticoService.findByNombre(nombre);	
		}
		
		@DeleteMapping("/partidopolitico/eliminar/{nombre}")
		public void deletePartidoPolitico(@PathVariable String nombre) {
			partidopoliticoService.deletePartidoPolitico(nombre);	
		
		}
}
