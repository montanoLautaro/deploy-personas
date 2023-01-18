package com.example.ejerciciodeploy.services;

import com.example.ejerciciodeploy.models.Persona;

import java.util.List;

public interface PersonaService {
    public List<Persona> listarPersonas();
    public Persona guardarPersona(Persona persona);
    public Persona obtenerPersonaPorId(Long id);
    public Persona actualizarPersona(Persona persona);
    public void eliminarPersona(Long id);
}
