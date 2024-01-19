package com.iformal.iformal.services.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iformal.iformal.dto.ServicoDto;
import com.iformal.iformal.model.Categorias;
import com.iformal.iformal.model.Servicos;
import com.iformal.iformal.repository.ServicosRepository;
import com.iformal.iformal.services.IServicosService;


@Service
public class ServicosService implements IServicosService {

@Autowired
ServicosRepository servicosRepository;
@Autowired
CategoriaService categoriaService;

    @Override
    public Servicos save(ServicoDto servicoDto) {
        Categorias categoria = this.categoriaService.listById(servicoDto.categoriaId());
        var servico = new Servicos();
        BeanUtils.copyProperties(servicoDto, servico);
        servico.setCategoria(categoria);
        return this.servicosRepository.save(servico);
    }

    @Override
    public Servicos update(ServicoDto servicoDto, int id) {
        var servico = this.listById(id);
        BeanUtils.copyProperties(servicoDto, servico);
        Categorias categoria = this.categoriaService.listById(servicoDto.categoriaId());
        servico.setCategoria(categoria);
        return this.servicosRepository.save(servico);
    }

    @Override
    public void delete(int servicoId) {
        Servicos servico = this.listById(servicoId);
        this.servicosRepository.delete(servico);
    }

    @Override
    public List<Servicos> listAll() {
        return this.servicosRepository.findAll();
    }

    @Override
    public List<Servicos> listAllByCategoria(int categoriaId) {
        Categorias categoria = categoriaService.listById(categoriaId);
        return this.servicosRepository.findByCategoriaId(categoria.getId());
    }

    @Override
    public Servicos listById(int id) {
        return this.servicosRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Serviço Inexistente."));
    }
    
}
