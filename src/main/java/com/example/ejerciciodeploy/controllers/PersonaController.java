package com.example.ejerciciodeploy.controllers;

import com.example.ejerciciodeploy.models.Persona;
import com.example.ejerciciodeploy.repositories.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PersonaController {
    private PersonaRepository personaRepository;
    private final Logger log = LoggerFactory.getLogger(PersonaController.class);

    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @GetMapping("/")
    public String bootstrap(){
        return """
                <!doctype html>
                <html lang="esp">
                  <head>
                    <!-- Required meta tags -->
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                                
                    <!-- Bootstrap CSS -->
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                                
                    <title>Personas App</title>
                  </head>
                  <body>
                    <h1>Bienvienido a la app de personas!</h1>
                    <a class="btn btn-primary" href="https://www.google.com.ar/"> Lista de personas </a>   
                    <a class="btn btn-primary" href="https://www.google.com.ar/"> Agregar una nueva persona </a> 
                    <a class="btn btn-primary" href="https://www.google.com.ar/"> Eliminar persona </a>  
                    <!-- Optional JavaScript; choose one of the two! -->
                                
                    <!-- Option 1: Bootstrap Bundle with Popper -->
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
                                
                    <!-- Option 2: Separate Popper and Bootstrap JS -->
                    <!--
                    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.2/dist/umd/popper.min.js" integrity="sha384-q9CRHqZndzlxGLOj+xrdLDJa9ittGte1NksRmgJKeCV9DrM7Kz868XYqsKWPpAmn" crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
                    -->
                  </body>
                </html>
                                
                                
                """;
    }

    @GetMapping("api/books/{id}")
    public ResponseEntity<Persona> findById(@PathVariable Long id){
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if(personaOptional.isPresent()){
            return ResponseEntity.ok(personaOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
