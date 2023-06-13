package com.example.apicervezas.controllers;

import com.example.apicervezas.dto.CervezaDto;
import com.example.apicervezas.entities.Cerveza;
import com.example.apicervezas.services.CervezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/cerveza")
public class CervezaController {
    @Autowired
    private CervezaService service;
    @GetMapping
    public ResponseEntity<List<Cerveza>> getAllByStatus(){
        return new ResponseEntity<>(service.getAllByStatus(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Cerveza> createCerveza(@RequestBody CervezaDto cervezaDto){
        return new ResponseEntity<>(service.createCerveza(cervezaDto),HttpStatus.CREATED);
    }
    @PutMapping("/update/{idCerveza}")
    public ResponseEntity<Cerveza> updateCerveza(@PathVariable("idCerveza") Integer id, @RequestBody CervezaDto cervezaDto){
        return new ResponseEntity<>(service.updateCerveza(id,cervezaDto),HttpStatus.OK);
    }
    @PutMapping("/delete/{idCerveza}")
    public ResponseEntity<Cerveza> deleteCerveza(@PathVariable("idCerveza") Integer id){
        return new ResponseEntity<>(service.deleteCerveza(id),HttpStatus.OK);
    }
}