package com.iformal.iformal.services;

import java.util.List;

import com.iformal.iformal.dto.AvaliacaoesDto;
import com.iformal.iformal.model.Avaliacoes;

public interface IAvaliacoesService {
    Avaliacoes save(AvaliacaoesDto dto);
    Avaliacoes update(AvaliacaoesDto dto, int id);
    void delete(int avaliacaoId);
    List<Avaliacoes> listAllByUsuario(int usuarioId);
    List<Avaliacoes> listAllByPrestador(int prestadorId);
    Avaliacoes listById(int id);

}
