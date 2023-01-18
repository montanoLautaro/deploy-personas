package com.example.ejerciciodeploy.services;

import com.example.ejerciciodeploy.models.Persona;
import com.example.ejerciciodeploy.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaServiceImpl implements PersonaService{

    private PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id).get();
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }


}
