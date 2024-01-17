package com.iformal.iformal.services;

import java.util.List;

import com.iformal.iformal.model.Servicos;

public interface IServicosService {
    Servicos save(Servicos servico);
    Servicos update(Servicos servico);
    void delete(int servicoId);
    List<Servicos> listAll();
    List<Servicos> listAllByCategoria(int categoriaId);
    Servicos listById(int id);
}
