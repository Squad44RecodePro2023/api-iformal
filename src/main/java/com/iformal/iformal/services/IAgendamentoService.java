package com.iformal.iformal.services;

import java.util.List;

import com.iformal.iformal.dto.AgendamentoDto;
import com.iformal.iformal.model.Agendamentos;

public interface IAgendamentoService {
    Agendamentos save(AgendamentoDto agendamentoDto);
    Agendamentos update(AgendamentoDto agendamentoDto, int id);
    void delete(int agendamentoId);
    List<Agendamentos> listAllByUsuario(int usuarioId);
    List<Agendamentos> listAllByPrestador(int prestadorId);
    Agendamentos listById(int id);
}
