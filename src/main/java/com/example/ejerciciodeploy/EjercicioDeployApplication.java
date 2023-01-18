package com.example.ejerciciodeploy;

import com.example.ejerciciodeploy.models.Persona;
import com.example.ejerciciodeploy.repositories.PersonaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjercicioDeployApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjercicioDeployApplication.class, args);
		PersonaRepository personaRepository = context.getBean(PersonaRepository.class);

		personaRepository.save(new Persona(null, "Romina", "Gomez", "Estudiante"));
		personaRepository.save(new Persona(null, "Juan", "Perez", "Profesor"));
		personaRepository.save(new Persona(null, "Esteban", "Quito", "Estudiante"));

	}

}
