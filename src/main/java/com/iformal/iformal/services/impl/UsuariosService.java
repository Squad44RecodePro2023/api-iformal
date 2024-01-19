package com.iformal.iformal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iformal.iformal.model.Usuarios;
import com.iformal.iformal.repository.UsuariosRepository;
import com.iformal.iformal.services.IUsuariosService;

@Service
public class UsuariosService implements IUsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;

    @Override
    public Usuarios save(Usuarios usuario) {
        return this.usuariosRepository.save(usuario);
    }

    @Override
    public Usuarios update(Usuarios usuario) {
        return this.usuariosRepository.save(usuario);
    }

    @Override
    public void delete(int usuarioId) {        
        Usuarios usuario = this.listById(usuarioId);
        this.usuariosRepository.delete(usuario);
    }

    @Override
    public List<Usuarios> listAll() {
        return this.usuariosRepository.findAll();
    }

    @Override
    public List<Usuarios> listByName(String name) {
        return this.usuariosRepository.findByNomeContaining(name);
    }

    @Override
    public Usuarios listByEmail(String email) {
        return this.usuariosRepository.findByEmail(email) //retorna um optinonal
                .orElseThrow(() -> new RuntimeException("Usuário Inexistente")); //caso o optional seja nulo
    }

    @Override
    public Usuarios listById(int usuarioId) {
        return this.usuariosRepository.findById(usuarioId) //retorna um optinonal
                .orElseThrow(() -> new RuntimeException("Usuário Inexistente")); //caso o optional seja nulo
    }

}
