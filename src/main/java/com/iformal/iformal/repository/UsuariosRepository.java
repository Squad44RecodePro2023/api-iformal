package com.iformal.iformal.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iformal.iformal.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    Optional<Usuarios> findByEmail(String email);
    List<Usuarios> findByNomeContaining(String nome);

}
