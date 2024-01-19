package com.iformal.iformal.controller;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iformal.iformal.dto.ComentarioDto;
import com.iformal.iformal.dto.ServicoDto;
import com.iformal.iformal.model.Comentarios;
import com.iformal.iformal.model.Servicos;
import com.iformal.iformal.services.impl.CategoriaService;
import com.iformal.iformal.services.impl.ComentariosService;
import com.iformal.iformal.services.impl.ServicosService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/servicos")
public class ServicosController {

    @Autowired
    ServicosService servicosService;
    @Autowired
    CategoriaService categoriaService;

    @Operation(summary = "Retorna uma lista com todos os Serviços")
    @GetMapping()
    public ResponseEntity<List<Servicos>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.servicosService.listAll());
    }

    @Operation(summary = "Retorna um serviço pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<Servicos> getById(@PathVariable (value = "id") int id){
        var servico = this.servicosService.listById(id);
        return ResponseEntity.status(HttpStatus.OK).body(servico);
    }

    @Operation(summary = "Retorna uma Lista serviço pelo id da categoria")
    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Servicos>> getByCategoriaId(@PathVariable (value = "id") int id){
        var servicoList = this.servicosService.listAllByCategoria(id);
        return ResponseEntity.status(HttpStatus.OK).body(servicoList);
    }

    @Operation(summary = "Deleta um serviço pelo id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByID(@PathVariable (value = "id") int id){
        this.servicosService.delete(id);
    }

    @Operation(summary = "Salva um novo serviço")
    @PostMapping
    public ResponseEntity<Servicos> save(@RequestBody @Valid ServicoDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.servicosService.save(dto));
        
    }

    @Operation(summary = "Atualiza um Serviço")
    @PutMapping
    public ResponseEntity<Servicos> update(@PathParam (value = "id") int id, @RequestBody @Valid ServicoDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(this.servicosService.update(dto, id));
        
    }
    
}
