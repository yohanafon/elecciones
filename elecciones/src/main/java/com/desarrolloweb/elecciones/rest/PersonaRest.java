package com.desarrolloweb.elecciones.rest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desarrolloweb.elecciones.annotations.isAdmin;
import com.desarrolloweb.elecciones.dtos.PersonaDTO;
import com.desarrolloweb.elecciones.entities.Persona;
import com.desarrolloweb.elecciones.security.services.IPersonaService;



@RestController
@RequestMapping("elecciones")
@isAdmin
public class PersonaRest {
	

	@Autowired
	private IPersonaService personaService;
		
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/personas/{page}/{size}")
	public List<PersonaDTO> getPersonas(@PathVariable("page") int page, @PathVariable("size") int size) {
		
		Page<Persona> personas = personaService.getPersonas(PageRequest.of(page, size));
		
		List<PersonaDTO> result = new ArrayList<>();
		for (Persona persona : personas) {
			result.add(mapper.map(persona, PersonaDTO.class));
		}
		return result;
	}
	
	
	@GetMapping("/personas")
	public List<Persona> index() {
		return personaService.findAll();
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_VIEWER"})
	@GetMapping("/persona/consultar/{cedula}")
	public Optional<Persona> findByCedula(@PathVariable Long cedula) {
		return personaService.findByCedula(cedula);
		
	}
	
	@PostMapping("/persona/crear")
	public Persona crearPersona(@RequestBody Persona newPersona) {
		return personaService.crearPersona(newPersona);
}
	
	@DeleteMapping("/persona/eliminar/{cedula}")
	public void deletePersona(@PathVariable Long cedula) {
		personaService.deletePersona(cedula);	
	
	}
	
	@PutMapping("/persona/actualizar/{cedula}")
	public Persona actualizarPersona(@RequestBody Persona newPersona, @PathVariable Long cedula) {
		return personaService.actualizarPersona(newPersona, cedula);
	}
}



