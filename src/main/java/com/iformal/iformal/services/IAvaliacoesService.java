package com.iformal.iformal.services;

import java.util.List;

import com.iformal.iformal.model.Avaliacoes;

public interface IAvaliacoesService {
    Avaliacoes save(Avaliacoes avaliacao);
    Avaliacoes update(Avaliacoes avaliacao);
    void delete(int avaliacaoId);
    List<Avaliacoes> listAllByUsuario(int usuarioId);
    List<Avaliacoes> listAllByPrestador(int prestadorId);
    Avaliacoes listById(int id);

}
