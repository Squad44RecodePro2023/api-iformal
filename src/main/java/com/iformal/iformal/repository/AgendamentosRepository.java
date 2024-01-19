package com.iformal.iformal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.iformal.iformal.model.Agendamentos;

public interface AgendamentosRepository extends JpaRepository<Agendamentos, Integer>{


    List<Agendamentos> findByUsuario_Id(int usuariosId);
    List<Agendamentos> findByPrestador_Id(int prestadorId);
    
} 
