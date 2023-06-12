package com.example.apicervezas.services;

import com.example.apicervezas.dto.MarcaDto;
import com.example.apicervezas.entities.Marca;
import com.example.apicervezas.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository repository;
    public List<Marca> getAllByStatus(){
        return repository.getAllByStatus();
    }
    public Marca createMarca(MarcaDto marcaDto){
        Marca marca=new Marca();
        marca.setNombre(marcaDto.getNombre());
        marca.setDescripcion(marcaDto.getDescripcion());
        marca.setStatus(marcaDto.getStatus());
        return repository.save(marca);
    }
    public Marca updateMarca(Integer id,MarcaDto marcaDto){
        if(repository.findById(id).isPresent()){
            Marca marca = repository.getReferenceById(id);
            marca.setNombre(marcaDto.getNombre());
            marca.setDescripcion(marcaDto.getDescripcion());
            return repository.save(marca);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Marca %s doesn´t exist",id));
        }
    }
    public Marca deleteMarca(Integer id){
        if(repository.findById(id).isPresent()){
            Marca m= repository.getReferenceById(id);
            m.setStatus((byte) 0);
            return repository.save(m);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Contenido %s doesn´t exist",id));
        }
    }
}
