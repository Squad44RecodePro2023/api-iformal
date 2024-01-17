package com.iformal.iformal.services;

import java.util.List;

import com.iformal.iformal.model.Usuarios;

public interface IUsuariosService {
    Usuarios save(Usuarios usuario);
    Usuarios update(Usuarios usuario);
    void delete(int usuarioId);
    List<Usuarios> listAll();
    List<Usuarios> listByName(String name);
    Usuarios listByEmail(String email);
    Usuarios listById(int usuarioId);
}
