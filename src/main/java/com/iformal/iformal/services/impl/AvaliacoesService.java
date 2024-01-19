package com.iformal.iformal.services.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iformal.iformal.dto.AvaliacaoesDto;
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
    public Avaliacoes save(AvaliacaoesDto dto) {
        var avaliacao = new Avaliacoes();
        Usuarios usuario = this.usuariosService.listById(dto.usuarioId());
        Prestador prestador = this.prestadorService.listById(dto.prestadorId());        
        BeanUtils.copyProperties(dto, avaliacao); 
        avaliacao.setPrestador(prestador);
        avaliacao.setUsuario(usuario);
        return this.avaliacoesRepository.save(avaliacao);
    }

    @Override
    public Avaliacoes update(AvaliacaoesDto dto, int id) {
        var avaliacao = this.listById(id);
        Usuarios usuario = this.usuariosService.listById(dto.usuarioId());
        Prestador prestador = this.prestadorService.listById(dto.prestadorId());        
        BeanUtils.copyProperties(dto, avaliacao); 
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
        return this.avaliacoesRepository.findByUsuario_Id(usuarioId);
    }

    @Override
    public List<Avaliacoes> listAllByPrestador(int prestadorId) {
        return this.avaliacoesRepository.findByPrestador_Id(prestadorId);
    }

    @Override
    public Avaliacoes listById(int id) {
       return this.avaliacoesRepository.findById(id)
       .orElseThrow(() -> new RuntimeException("Avaliação Inexistente"));
    }

}
