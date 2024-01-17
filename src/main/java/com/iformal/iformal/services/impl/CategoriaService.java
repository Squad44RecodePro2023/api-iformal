package com.iformal.iformal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iformal.iformal.model.Categorias;
import com.iformal.iformal.repository.CategoriasRepository;
import com.iformal.iformal.services.ICategoriasService;

@Service
public class CategoriaService implements ICategoriasService {
    @Autowired
    CategoriasRepository categoriasRepository;

    @Override
    public Categorias save(Categorias categoria) {
        return this.categoriasRepository.save(categoria);
    }

    @Override
    public Categorias update(Categorias categoria) {        
        return this.categoriasRepository.save(categoria);
    }

    @Override
    public void delete(int categoriaId) {
        Categorias categoria = this.listById(categoriaId);
        this.categoriasRepository.delete(categoria);
    }

    @Override
    public List<Categorias> listAll() {
        return this.categoriasRepository.findAll();
    }

    @Override
    public Categorias listById (int id) {
        return this.categoriasRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Prestador Inexistente"));
    }
    
}
