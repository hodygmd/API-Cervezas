package com.example.apicervezas.repositories;

import com.example.apicervezas.entities.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido,Integer> {
    @Query("SELECT c FROM Contenido c WHERE c.status=1")
    public List<Contenido> getAllByStatus();
    @Query("SELECT c.cantidad FROM Contenido c WHERE c.status=1")
    public List<String> getCantidadesByStatus();
}
