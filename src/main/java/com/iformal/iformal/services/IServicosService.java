package com.iformal.iformal.services;

import java.util.List;

import com.iformal.iformal.dto.ServicoDto;
import com.iformal.iformal.model.Servicos;

public interface IServicosService {
    Servicos save(ServicoDto servicoDto);
    Servicos update(ServicoDto servicoDto, int id);
    void delete(int servicoId);
    List<Servicos> listAll();
    List<Servicos> listAllByCategoria(int categoriaId);
    Servicos listById(int id);
}
