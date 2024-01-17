package com.iformal.iformal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iformal.iformal.model.Agendamentos;
import com.iformal.iformal.model.Prestador;
import com.iformal.iformal.model.Servicos;
import com.iformal.iformal.model.Usuarios;
import com.iformal.iformal.repository.AgendamentosRepository;
import com.iformal.iformal.services.IAgendamentoService;

@Service
public class AgendamentoService implements IAgendamentoService {
@Autowired
AgendamentosRepository agendamentosRepository;
@Autowired
UsuariosService usuariosService;
@Autowired
PrestadorService prestadorService;
@Autowired
ServicosService servicosService;
   

    @Override
    public Agendamentos save(Agendamentos agendamento) {
        Prestador prestador = this.prestadorService.listById(agendamento.getPrestador().getId());
        Usuarios usuarios = this.usuariosService.listById(agendamento.getUsuario().getId());
        Servicos servicos = this.servicosService.listById(agendamento.getServico().getId());
        agendamento.setPrestador(prestador);
        agendamento.setUsuario(usuarios);
        agendamento.setServico(servicos);
        return this.agendamentosRepository.save(agendamento);
    }

    @Override
    public Agendamentos update(Agendamentos agendamento) {
        Prestador prestador = this.prestadorService.listById(agendamento.getPrestador().getId());
        Usuarios usuarios = this.usuariosService.listById(agendamento.getUsuario().getId());
        Servicos servicos = this.servicosService.listById(agendamento.getServico().getId());
        agendamento.setPrestador(prestador);
        agendamento.setUsuario(usuarios);
        agendamento.setServico(servicos);
        return this.agendamentosRepository.save(agendamento);
    }

    @Override
    public void delete(int agendamentoId) {
        Agendamentos agendamento = this.listById(agendamentoId);
        this.agendamentosRepository.delete(agendamento);
    }

    @Override
    public List<Agendamentos> listAllByUsuario(int usuarioId) {
        return this.agendamentosRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Agendamentos> listAllByPrestador(int prestadorId) {
        return this.agendamentosRepository.findByPrestadoId(prestadorId);
    }

    @Override
    public Agendamentos listById(int id) {
        return this.agendamentosRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Prestador Inexistente"));
    }
    
}
