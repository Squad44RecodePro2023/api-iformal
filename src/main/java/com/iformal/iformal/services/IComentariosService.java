package com.iformal.iformal.services;

import java.util.List;

import com.iformal.iformal.model.Comentarios;

public interface IComentariosService {
    Comentarios save(Comentarios comentario);
    Comentarios update(Comentarios comentario);
    void delete(int comentarioId);
    List<Comentarios> listAll();
    Comentarios listById(int id);
}
