package com.iformal.iformal.controller;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iformal.iformal.dto.ComentarioDto;
import com.iformal.iformal.model.Comentarios;
import com.iformal.iformal.services.impl.ComentariosService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin("http://localhost:3000/")
public class ComentariosController {
    @Autowired
    ComentariosService comentariosService;

    @Operation(summary = "Retorna uma lista com todos os comentarios")
    @GetMapping()
    public ResponseEntity<List<Comentarios>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.comentariosService.listAll());
    }

    @Operation(summary = "Retorna um comentario pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<Comentarios> getById(@PathVariable (value = "id") int id){
        var comentario = this.comentariosService.listById(id);
        return ResponseEntity.status(HttpStatus.OK).body(comentario);
    }

    @Operation(summary = "Deleta um comentario pelo id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByID(@PathVariable (value = "id") int id){
        this.comentariosService.delete(id);
    }

    @Operation(summary = "Salva um novo comentario")
    @PostMapping
    public ResponseEntity<Comentarios> save(@RequestBody @Valid ComentarioDto dto){
        var comentario = new Comentarios();
        BeanUtils.copyProperties(dto, comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.comentariosService.save(comentario));
        
    }

    @Operation(summary = "Atualiza um Comentario")
    @PutMapping
    public ResponseEntity<Comentarios> update(@PathParam (value = "id") int id, @RequestBody @Valid ComentarioDto dto){
        var comentario = this.comentariosService.listById(id);
        BeanUtils.copyProperties(dto, comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.comentariosService.save(comentario));
        
    }
}
