package com.iformal.iformal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.iformal.iformal.model.Servicos;

public interface ServicosRepository extends JpaRepository<Servicos, Integer>{
    
    List<Servicos> findByCategoriaId(int categoria_id);

    
} 
