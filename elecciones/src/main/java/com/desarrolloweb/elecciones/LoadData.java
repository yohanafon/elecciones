package com.desarrolloweb.elecciones;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.desarrolloweb.elecciones.entities.Boletin;
import com.desarrolloweb.elecciones.entities.CandidatoVoto;
import com.desarrolloweb.elecciones.entities.LocalVotacion;
import com.desarrolloweb.elecciones.entities.MesaVotacion;
import com.desarrolloweb.elecciones.entities.PartidoPolitico;
import com.desarrolloweb.elecciones.entities.Persona;
import com.desarrolloweb.elecciones.entities.Tipo;
import com.desarrolloweb.elecciones.entities.Usuario;
import com.desarrolloweb.elecciones.repository.UsuarioRepository;
import com.desarrolloweb.elecciones.security.model.Role;
import com.desarrolloweb.elecciones.repository.BoletinRepository;
import com.desarrolloweb.elecciones.repository.CandidatoVotoRepository;
import com.desarrolloweb.elecciones.repository.LocalVotacionRepository;
import com.desarrolloweb.elecciones.repository.MesaVotacionRepository;
import com.desarrolloweb.elecciones.repository.PartidoPoliticoRepository;
import com.desarrolloweb.elecciones.repository.PersonaRepository;
import com.desarrolloweb.elecciones.repository.RoleRepository;


@Configuration
class LoadDataBase {

	@Bean
	CommandLineRunner initDatabase(UsuarioRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder PasswordEncoder) {
		return args -> {
			
			Role adminRole = new Role();
			adminRole.setNombre("ADMIN");
			roleRepository.save(adminRole);
			
			Role viewerRole = new Role();
			viewerRole.setNombre("VIEWER");
			roleRepository.save(viewerRole);

			Usuario admin = new Usuario();
			admin.setNombreUsuario("admin");
			admin.setContraseña(PasswordEncoder.encode("12345"));
			admin.setRol(adminRole);
			userRepository.save(admin);
			
			Usuario visitor = new Usuario();
			visitor.setNombreUsuario("visitor");
			visitor.setContraseña(PasswordEncoder.encode("12345"));
			visitor.setRol(viewerRole);
			userRepository.save(visitor);
		};
	}
	
//	@Bean
//	CommandLineRunner initDatabasePersona(PersonaRepository personarepository, 
//			PartidoPoliticoRepository partidopoliticorepository,
//			CandidatoVotoRepository candidatovotorepository) {
//		return args -> {
//			System.out.println("Probando la capa de servicios");
//			
//			
//			// siempre debe quedar arriba y abajo queda lo que le vas agregqar y luego haces esto
//			PartidoPolitico centrodemocratico = new PartidoPolitico();
//			centrodemocratico.setNombre("Centro Democratico");
//			partidopoliticorepository.save(centrodemocratico);
//			
//
//			
//			Persona persona = new Persona();
//			persona.setCedula((long) 105144488);
//	    	persona.setTipo(Tipo.APODERADO);
//			persona.setNombre("Santiago");
//			persona.setApellido("Ramirez");
//			persona.setEdad("31");
//			persona.setPartidoPolitico(null);
//			personarepository.save(persona);
//			
//			 
//			
//			Persona persona2 = new Persona();
//			persona2.setCedula((long) 46582145);
//			persona2.setTipo(Tipo.VOTANTE);
//			persona2.setNombre("Karen");
//			persona2.setApellido("Lopez");
//			persona2.setEdad("25");
//			personarepository.save(persona2);
//		
//			persona = new Persona();
//			persona.setCedula((long) 1051477489);
//			persona.setTipo(Tipo.CANDIDATO);
//			persona.setNombre("Sofia");
//			persona.setApellido("Mesa");
//			persona.setEdad("32");
//			personarepository.save(persona);
//		
//			persona = new Persona();
//			persona.setCedula((long) 46375139);
//			persona.setTipo(Tipo.JURADO);
//			persona.setNombre("Natali");
//			persona.setApellido("Pacheco");
//			persona.setEdad("27");
//			personarepository.save(persona);
//		};
//	}
//	
//	@Bean
//	CommandLineRunner initDatabaseLocal(LocalVotacionRepository localvotacionrepository) {
//		return args -> {
//			System.out.println("Probando la capa de servicios");
//			
//			LocalVotacion localvotacion1 = new LocalVotacion();
//			localvotacion1.setNombre("Colegio Senderito");
//			localvotacion1.setCiudad("Aquitania");
//			localvotacion1.setMesavotacion(null);
//			localvotacionrepository.save(localvotacion1);
//			
//			LocalVotacion localvotacion2 = new LocalVotacion();
//			localvotacion2.setNombre("Colegio Campestre");
//			localvotacion2.setCiudad("Sogamoso");
//			localvotacionrepository.save(localvotacion2);
//			
//			LocalVotacion localvotacion3 = new LocalVotacion();
//			localvotacion3.setNombre("Colegio Avella");
//			localvotacion3.setCiudad("Duitama");
//			localvotacionrepository.save(localvotacion3);
//			
//			LocalVotacion localvotacion4 = new LocalVotacion();
//			localvotacion4.setNombre("Colegio Upc");
//			localvotacion4.setCiudad("Tunja");
//			localvotacionrepository.save(localvotacion4);
//		};
//	}
//	
//	
//	@Bean
//	CommandLineRunner initDatabasePartido(PartidoPoliticoRepository partidopoliticorepository, 
//			PersonaRepository personarepository) {
//		return args -> {
//			System.out.println("Probando la capa de servicios");
//			
//
//			
//		PartidoPolitico partidopolitico = new PartidoPolitico();
//			partidopolitico.setNombre("Centro Democratico");
//			partidopoliticorepository.save(partidopolitico);
//			
//
//			
//			PartidoPolitico partidopolitico = new PartidoPolitico();
//	    	partidopolitico.setNombre("Cambio Radical");
//	    	partidopoliticorepository.save(partidopolitico);
//
//			partidopolitico = new PartidoPolitico();
//			partidopolitico.setNombre("Polo");
//			partidopoliticorepository.save(partidopolitico);
//			
//			partidopolitico = new PartidoPolitico();
//			partidopolitico.setNombre("Mira");
//			partidopoliticorepository.save(partidopolitico);
//			
//		};
//	}
	
	@Bean
	CommandLineRunner initDatabaseVoto(CandidatoVotoRepository candidatovotorepository,
			PersonaRepository personarepository, PartidoPoliticoRepository partidopoliticorepository,
			MesaVotacionRepository mesavotacionrepository, LocalVotacionRepository localvotacionrepository,
			BoletinRepository boletinrepository) {
		return args -> {
			
			//persona1
			Persona persona1 = new Persona();
			persona1.setCedula((long)105144488);
			persona1.setTipo(Tipo.APODERADO);
			persona1.setNombre("Santiago");
			persona1.setApellido("Ramirez");
			persona1.setEdad("31");
			persona1.setPartidoPolitico(null);
			personarepository.save(persona1);
			
		
			PartidoPolitico partidopolitico = new PartidoPolitico();
			partidopolitico.setNombre("Mira");
			partidopolitico.setPersona(persona1);
			partidopoliticorepository.save(partidopolitico);
			
			MesaVotacion mesavotacion = new MesaVotacion();
			mesavotacion.setPersona(persona1);
			mesavotacionrepository.save(mesavotacion);
			
			LocalVotacion localvotacion1 = new LocalVotacion();
			localvotacion1.setNombre("Colegio Senderito");
			localvotacion1.setCiudad("Aquitania");
			localvotacion1.setMesavotacion(mesavotacion);
			localvotacionrepository.save(localvotacion1);
			
	//persona2		
			Persona persona2 = new Persona();
			persona2.setCedula((long) 46582145);
			persona2.setTipo(Tipo.VOTANTE);
			persona2.setNombre("Karen");
			persona2.setApellido("Lopez");
			persona2.setEdad("25");
			personarepository.save(persona2);
			
			
			partidopolitico = new PartidoPolitico();
	    	partidopolitico.setNombre("Cambio Radical");
	    	partidopolitico.setPersona(persona2);
	    	partidopoliticorepository.save(partidopolitico);
	        
	    	mesavotacion = new MesaVotacion();
			mesavotacion.setPersona(persona2);
			mesavotacionrepository.save(mesavotacion);
			
			LocalVotacion localvotacion2 = new LocalVotacion();
			localvotacion2.setNombre("Colegio Campestre");
			localvotacion2.setCiudad("Sogamoso");
			localvotacion2.setMesavotacion(mesavotacion);
			localvotacionrepository.save(localvotacion2);
	    	
	   //persona3 	
			Persona persona3 = new Persona();
			persona3.setCedula((long) 1051477489);
			persona3.setTipo(Tipo.CANDIDATO);
			persona3.setNombre("Sofia");
			persona3.setApellido("Mesa");
			persona3.setEdad("32");
			personarepository.save(persona3);
			
			CandidatoVoto candidatovoto = new CandidatoVoto();
			candidatovoto.setCantidad("2.145");
			candidatovoto.setPersona(persona3);
			candidatovotorepository.save(candidatovoto);
			
			partidopolitico = new PartidoPolitico();
			partidopolitico.setNombre("Centro Democratico");
			partidopolitico.setPersona(persona3);
			partidopoliticorepository.save(partidopolitico);
			
			mesavotacion = new MesaVotacion();
			mesavotacion.setPersona(persona3);
			mesavotacionrepository.save(mesavotacion);
			
			LocalVotacion localvotacion3 = new LocalVotacion();
			localvotacion3.setNombre("Colegio Avella");
			localvotacion3.setCiudad("Duitama");
			localvotacion3.setMesavotacion(mesavotacion);
			localvotacionrepository.save(localvotacion3);
			
			Boletin boletin = new Boletin();
			boletin.setMesavotacion(mesavotacion);
			boletin.setCandidatovoto(candidatovoto);
			boletinrepository.save(boletin);
			
			
		//persona 4	
	        Persona persona4 = new Persona();
	        persona4.setCedula((long) 46375139);
	        persona4.setTipo(Tipo.JURADO);
	        persona4.setNombre("Natali");
	        persona4.setApellido("Pacheco");
	        persona4.setEdad("27");
			personarepository.save(persona4);
			
				
			partidopolitico = new PartidoPolitico();
			partidopolitico.setNombre("Polo");
			partidopolitico.setPersona(persona4);
			partidopoliticorepository.save(partidopolitico);
			
			mesavotacion = new MesaVotacion();
			mesavotacion.setPersona(persona4);
			mesavotacionrepository.save(mesavotacion);
			
			LocalVotacion localvotacion4 = new LocalVotacion();
			localvotacion4.setNombre("Colegio Upc");
			localvotacion4.setCiudad("Tunja");
			localvotacion4.setMesavotacion(mesavotacion);
			localvotacionrepository.save(localvotacion4);
			
			
			//persona 5
		
	        Persona persona5 = new Persona();
	        persona5.setCedula((long) 1452365894);
	        persona5.setTipo(Tipo.CANDIDATO);
	        persona5.setNombre("Sara");
	        persona5.setApellido("Ruiz");
	        persona5.setEdad("26");
			personarepository.save(persona5);
			
			candidatovoto = new CandidatoVoto();
			candidatovoto.setCantidad("2.564");
			candidatovoto.setPersona(persona5);
			candidatovotorepository.save(candidatovoto);
			
			partidopolitico = new PartidoPolitico();
			partidopolitico.setNombre("Conservador");
			partidopolitico.setPersona(persona5);
			partidopoliticorepository.save(partidopolitico);
			
			mesavotacion = new MesaVotacion();
			mesavotacion.setPersona(persona5);
			mesavotacionrepository.save(mesavotacion);
			
			 boletin = new Boletin();
			boletin.setMesavotacion(mesavotacion);
			boletin.setCandidatovoto(candidatovoto);
			boletinrepository.save(boletin);
		};
	}
	
}