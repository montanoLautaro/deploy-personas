package com.example.ejerciciodeploy.services;

import com.example.ejerciciodeploy.models.Persona;
import com.example.ejerciciodeploy.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }
}
