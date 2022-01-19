package com.desarrolloweb.elecciones.rest;

import java.util.ArrayList;
import java.util.List;

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
import com.desarrolloweb.elecciones.dtos.MesaVotacionDTO;
import com.desarrolloweb.elecciones.entities.MesaVotacion;
import com.desarrolloweb.elecciones.entities.Persona;
import com.desarrolloweb.elecciones.security.services.IMesaVotacionService;

@RestController
@RequestMapping("elecciones")
@isAdmin
public class MesaVotacionRest {

	@Autowired
	private IMesaVotacionService mesavotacionService;
	
	@Autowired
	private ModelMapper mapper;
	

		@GetMapping("/mesavotaciones/{page}/{size}")
		public List<MesaVotacionDTO> getMesaVotacion(@PathVariable("page") int page, @PathVariable("size") int size) {
			
			Page<MesaVotacion> mesavotaciones = mesavotacionService.getMesaVotaciones(PageRequest.of(page, size));
			
			List<MesaVotacionDTO> result = new ArrayList<>();
			for (MesaVotacion mesavotacion : mesavotaciones) {
				result.add(mapper.map(mesavotacion, MesaVotacionDTO.class));
			}
			return result;
		
			}
		
		@PostMapping("/mesavotacion/crear")
		public MesaVotacion crearMesaVotacion(@RequestBody MesaVotacion newMesaVotacion) {
			return mesavotacionService.crearMesaVotacion(newMesaVotacion);
	}
		
		@DeleteMapping("/mesavotacion/eliminar/{id}")
		public void deleteMesaVotacion(@PathVariable Long id) {
			mesavotacionService.deleteMesaVotacion(id);	
		
		}
	
}
