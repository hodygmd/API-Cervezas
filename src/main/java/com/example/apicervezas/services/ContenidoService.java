package com.example.apicervezas.services;

import com.example.apicervezas.dto.ContenidoDto;
import com.example.apicervezas.entities.Contenido;
import com.example.apicervezas.entities.Marca;
import com.example.apicervezas.repositories.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ContenidoService {
    @Autowired
    private ContenidoRepository repository;
    public List<Contenido> getAllByStatus(){
        return repository.getAllByStatus();
    }
    public Contenido createContenido(ContenidoDto contenidoDto){
        Contenido contenido=new Contenido();
        contenido.setCantidad(contenidoDto.getCantidad());
        contenido.setStatus(contenidoDto.getStatus());
        return repository.save(contenido);
    }
    public Contenido updateContenido(Integer id,ContenidoDto contenidoDto){
        if(repository.findById(id).isPresent()){
            Contenido contenido = repository.getReferenceById(id);
            contenido.setCantidad(contenidoDto.getCantidad());
            return repository.save(contenido);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Contenido %s doesn´t exist",id));
        }
    }
    public Contenido deleteContenido(Integer id){
        if(repository.findById(id).isPresent()){
            Contenido c= repository.getReferenceById(id);
            c.setStatus((byte) 0);
            return repository.save(c);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Contenido %s doesn´t exist",id));
        }
    }
}
