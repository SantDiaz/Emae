package com.example.emae.controllers;

import com.example.emae.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/upload")
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping
    public ResponseEntity<String> handleFormSubmit(@RequestParam("archivo") MultipartFile archivo) {
        try (InputStream inputStream = archivo.getInputStream()) {
            formService.processExcelFile(inputStream);
            return ResponseEntity.ok("Datos recibidos y procesados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error en el procesamiento del archivo");
        }
    }
}
