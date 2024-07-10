package com.example.emae.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FormController {

    @PostMapping
    public ResponseEntity<String> handleFormSubmit(
            @RequestParam("nombre") String nombre,
            @RequestParam("email") String email,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message,
            @RequestParam("archivo") MultipartFile archivo) {

        // Imprime los datos recibidos en la consola
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
        System.out.println("Archivo: " + archivo.getOriginalFilename());

        // Devuelve una respuesta que confirme la recepción de los datos
        return ResponseEntity.ok("Datos recibidos correctamente: " + nombre + ", " + email + ", " + subject + ", " + message + ", " + archivo.getOriginalFilename());
    }
}
