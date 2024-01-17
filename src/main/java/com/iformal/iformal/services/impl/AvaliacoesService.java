package com.iformal.iformal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iformal.iformal.model.Avaliacoes;
import com.iformal.iformal.model.Prestador;
import com.iformal.iformal.model.Usuarios;
import com.iformal.iformal.repository.AvaliacoesRepository;
import com.iformal.iformal.services.IAvaliacoesService;

@Service
public class AvaliacoesService implements IAvaliacoesService {
    @Autowired
    AvaliacoesRepository avaliacoesRepository;
    @Autowired
    UsuariosService usuariosService;
    @Autowired
    PrestadorService prestadorService;

    @Override
    public Avaliacoes save(Avaliacoes avaliacao) {
        Usuarios usuario = this.usuariosService.listById(avaliacao.getUsuario().getId());
        Prestador prestador = this.prestadorService.listById(avaliacao.getPrestador().getId());
        avaliacao.setPrestador(prestador);
        avaliacao.setUsuario(usuario);
        return this.avaliacoesRepository.save(avaliacao);
    }

    @Override
    public Avaliacoes update(Avaliacoes avaliacao) {
        Usuarios usuario = this.usuariosService.listById(avaliacao.getUsuario().getId());
        Prestador prestador = this.prestadorService.listById(avaliacao.getPrestador().getId());
        avaliacao.setPrestador(prestador);
        avaliacao.setUsuario(usuario);
        return this.avaliacoesRepository.save(avaliacao);
    }

    @Override
    public void delete(int avaliacaoId) {
        Avaliacoes avaliacao = this.listById(avaliacaoId);
        this.avaliacoesRepository.delete(avaliacao);
    }

    @Override
    public List<Avaliacoes> listAllByUsuario(int usuarioId) {
        return this.avaliacoesRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Avaliacoes> listAllByPrestador(int prestadorId) {
        return this.avaliacoesRepository.findByPrestadoId(prestadorId);
    }

    @Override
    public Avaliacoes listById(int id) {
       return this.avaliacoesRepository.findById(id)
       .orElseThrow(() -> new RuntimeException("Avaliação Inexistente"));
    }

}
