package com.example.apicervezas.controllers;

import com.example.apicervezas.dto.ContenidoDto;
import com.example.apicervezas.entities.Contenido;
import com.example.apicervezas.services.ContenidoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contenido")
public class ContenidoController {
    @Autowired
    private ContenidoService service;
    @GetMapping
    public ResponseEntity<List<Contenido>> getAllByStatus(){
        return new ResponseEntity<>(service.getAllByStatus(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Contenido> createContenido(@RequestBody ContenidoDto contenidoDto){
        return new ResponseEntity<>(service.createContenido(contenidoDto),HttpStatus.CREATED);
    }
    @PutMapping("/update/{idContenido}")
    public ResponseEntity<Contenido> updateContenido(@PathVariable("idContenido") Integer id, @RequestBody ContenidoDto contenidoDto){
        return new ResponseEntity<>(service.updateContenido(id,contenidoDto),HttpStatus.OK);
    }
    @PutMapping("/delete/{idContenido}")
    public ResponseEntity<Contenido> deleteContenido(@PathVariable("idContenido") Integer id){
        return new ResponseEntity<>(service.deleteContenido(id),HttpStatus.OK);
    }
}
