package com.example.ejerciciodeploy.controllers;

import com.example.ejerciciodeploy.models.Persona;
import com.example.ejerciciodeploy.services.PersonaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonaController {
    private PersonaService service;


    public PersonaController(PersonaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String bootstrap(){
        return "index";
    }


    @GetMapping("/personas")
    public String listarPersonas(Model modelo){
        modelo.addAttribute("personas", service.listarPersonas());
        return "personas";
    }

    @GetMapping("/personas/nuevo")
    public String mostrarFormularioCrearPersona(Model model){
        Persona persona = new Persona();
        model.addAttribute("persona", persona);
        return "crear_persona";
    }

    @PostMapping("/personas")
    public String crearPersona(@ModelAttribute("persona") Persona persona){
        service.guardarPersona(persona);
        return "redirect:/personas";
    }

    @GetMapping("/personas/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("persona", service.obtenerPersonaPorId(id));
        return "editar_persona";
    }

    @PostMapping("/personas/{id}")
    public String actualizarPersona(@PathVariable Long id, @ModelAttribute("persona") Persona persona, Model modelo){
        Persona personaExistente = service.obtenerPersonaPorId(id);
        personaExistente.setId(id);
        personaExistente.setNombre(persona.getNombre());
        personaExistente.setApellido(persona.getApellido());
        personaExistente.setRol(persona.getRol());
        service.actualizarPersona(personaExistente);
        return "redirect:/personas";
    }

    @GetMapping("/personas/{id}")
    public String eliminarPersona(@PathVariable Long id){
        service.eliminarPersona(id);
        return "redirect:/personas";
    }
}
