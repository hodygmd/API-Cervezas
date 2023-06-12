package com.example.apicervezas.repositories;

import com.example.apicervezas.entities.Cerveza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CervezaRepository extends JpaRepository<Cerveza,Integer> {
    @Query("SELECT c FROM Cerveza c WHERE c.status=1")
    public List<Cerveza> getAllByStatus();
}
