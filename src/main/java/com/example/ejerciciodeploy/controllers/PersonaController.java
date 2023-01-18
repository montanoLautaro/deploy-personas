package com.example.ejerciciodeploy.controllers;

import com.example.ejerciciodeploy.models.Persona;
import com.example.ejerciciodeploy.services.PersonaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        return "redirect:personas";
    }

}
