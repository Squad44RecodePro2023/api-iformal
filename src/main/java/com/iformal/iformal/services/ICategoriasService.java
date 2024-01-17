package com.iformal.iformal.services;

import java.util.List;

import com.iformal.iformal.model.Categorias;

public interface ICategoriasService {
    Categorias save(Categorias categoria);
    Categorias update(Categorias categoria);
    void delete(int categoriaId);
    List<Categorias> listAll();
    Categorias listById(int id);
}
