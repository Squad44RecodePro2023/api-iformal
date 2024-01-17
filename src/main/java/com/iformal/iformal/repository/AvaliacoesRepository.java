package com.iformal.iformal.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.iformal.iformal.model.Avaliacoes;

public interface AvaliacoesRepository extends JpaRepository<Avaliacoes, Integer>{

    List<Avaliacoes> findByUsuarioId(int usuarios_id);
    List<Avaliacoes> findByPrestadoId(int prestador_id);
} 
