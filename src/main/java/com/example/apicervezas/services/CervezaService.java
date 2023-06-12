package com.example.apicervezas.services;

import com.example.apicervezas.dto.CervezaDto;
import com.example.apicervezas.entities.Cerveza;
import com.example.apicervezas.repositories.CervezaRepository;
import com.example.apicervezas.repositories.ContenidoRepository;
import com.example.apicervezas.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CervezaService {
    @Autowired
    private CervezaRepository repository;
    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private ContenidoRepository contenidoRepository;
    public List<Cerveza> getAllByStatus(){
        return repository.getAllByStatus();
    }
    public Cerveza createCerveza(CervezaDto cervezaDto){
        if(marcaRepository.findById(cervezaDto.getId_marca()).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Marca %s doesn´t exist",cervezaDto.getId_marca()));
        }
        if(contenidoRepository.findById(cervezaDto.getId_contenido()).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Contenido %s doesn´t exist",cervezaDto.getId_contenido()));
        }
        Cerveza cerveza = new Cerveza();
        return getCerveza(cervezaDto, cerveza);
    }
    public Cerveza updateCerveza(Integer id, CervezaDto cervezaDto) {
        if(repository.findById(id).isPresent()){
            Cerveza cerveza = repository.getReferenceById(id);
            return getCerveza(cervezaDto, cerveza);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Animal %s doesn´t exist",id));
        }
    }
    public Cerveza deleteCerveza(Integer id){
        if(repository.findById(id).isPresent()){
            Cerveza c=repository.getReferenceById(id);
            c.setStatus((byte) 0);
            return repository.save(c);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Cerveza %s doesn´t exist",id));
        }
    }
    private Cerveza getCerveza(CervezaDto cervezaDto, Cerveza cerveza) {
        cerveza.setNombre(cervezaDto.getNombre());
        cerveza.setDescripcion(cervezaDto.getDescripcion());
        cerveza.setId_marca(marcaRepository.findById(cervezaDto.getId_marca()).get());
        cerveza.setId_contenido(contenidoRepository.findById(cervezaDto.getId_contenido()).get());
        cerveza.setStatus(cervezaDto.getStatus());
        return repository.save(cerveza);
    }
}
