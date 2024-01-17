package com.iformal.iformal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.iformal.iformal.model.Agendamentos;

public interface AgendamentosRepository extends JpaRepository<Agendamentos, Integer>{


    List<Agendamentos> findByUsuarioId(int usuarios_id);
    List<Agendamentos> findByPrestadoId(int prestador_id);
    
} 
