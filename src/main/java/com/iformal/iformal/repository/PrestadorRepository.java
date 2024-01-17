package com.iformal.iformal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iformal.iformal.model.Agendamentos;

public interface PrestadorRepository extends JpaRepository<Agendamentos, Integer>{

    
} 
