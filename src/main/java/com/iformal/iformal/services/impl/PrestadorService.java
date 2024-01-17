package com.iformal.iformal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iformal.iformal.model.Prestador;
import com.iformal.iformal.repository.PrestadorRepository;
import com.iformal.iformal.services.IPrestadorService;

@Service
public class PrestadorService implements IPrestadorService {

    @Autowired
    PrestadorRepository prestadorRepository;
    @Autowired
    UsuariosService usuariosService;

    @Override
    public Prestador save(Prestador prestador) {
        int idUsuario = prestador.getUsuario().getId();
        prestador.setUsuario(this.usuariosService.listById(idUsuario));
        return this.prestadorRepository.save(prestador);
    }

    @Override
    public Prestador update(Prestador prestador) {
        int idUsuario = prestador.getUsuario().getId();
        prestador.setUsuario(this.usuariosService.listById(idUsuario));
        return this.prestadorRepository.save(prestador);
    }

    @Override
    public void delete(int prestadorId) {
        Prestador prestador = this.listById(prestadorId);
        this.prestadorRepository.delete(prestador);
    }

    @Override
    public List<Prestador> listAll() {
        return this.prestadorRepository.findAll();
    }

    @Override
    public Prestador listById(int prestadorId) {        
        return this.prestadorRepository.findById(prestadorId) //retorna um optinonal
                .orElseThrow(() -> new RuntimeException("Prestador Inexistente")); //caso o optional seja nulo
    }
    
}
