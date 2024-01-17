package com.iformal.iformal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iformal.iformal.model.Comentarios;
import com.iformal.iformal.repository.ComentariosRepository;
import com.iformal.iformal.services.IComentariosService;


@Service
public class ComentariosService implements IComentariosService {

    @Autowired
    ComentariosRepository comentariosRepository;

    @Override
    public Comentarios save(Comentarios comentario) {
        return this.comentariosRepository.save(comentario);
    }

    @Override
    public Comentarios update(Comentarios comentario) {     
        return this.comentariosRepository.save(comentario);
    }

    @Override
    public void delete(int comentarioId) {
        Comentarios comentario = this.listById(comentarioId);
        this.comentariosRepository.delete(comentario);
    }

    @Override
    public List<Comentarios> listAll() {
        return this.comentariosRepository.findAll();
    }

    @Override
    public Comentarios listById(int id) {
        return this.comentariosRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Comentarios Inexistente"));
    }
    
}
