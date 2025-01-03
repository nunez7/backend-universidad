package com.vass.universidad.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi")
public class PrimerRestController {

    @GetMapping("/hola-mundo")
    public ResponseEntity<String> holaMundo(){
        return new ResponseEntity<>("Hola Mundo! =D", HttpStatus.ACCEPTED);
    }

}
