package com.example.apicervezas.controllers;

import com.example.apicervezas.dto.MarcaDto;
import com.example.apicervezas.entities.Marca;
import com.example.apicervezas.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {
    @Autowired
    private MarcaService service;
    @GetMapping
    public ResponseEntity<List<Marca>> getAllByStatus(){
        return new ResponseEntity<>(service.getAllByStatus(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Marca> createMarca(@RequestBody MarcaDto marcaDto){
        return new ResponseEntity<>(service.createMarca(marcaDto),HttpStatus.CREATED);
    }
    @PutMapping("/update/{idMarca}")
    public ResponseEntity<Marca> updateMarca(@PathVariable("idMarca") Integer id,@RequestBody MarcaDto marcaDto){
        return new ResponseEntity<>(service.updateMarca(id,marcaDto),HttpStatus.OK);
    }
    @PutMapping("/delete/{idMarca}")
    public ResponseEntity<Marca> deleteMarca(@PathVariable("idMarca") Integer id){
        return new ResponseEntity<>(service.deleteMarca(id),HttpStatus.OK);
    }
}
