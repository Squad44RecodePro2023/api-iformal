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

import com.iformal.iformal.dto.CategoriasDto;
import com.iformal.iformal.model.Categorias;
import com.iformal.iformal.services.impl.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @Operation(summary = "Retorna uma lista com todas as categorias")
    @GetMapping()
    public ResponseEntity<List<Categorias>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.categoriaService.listAll());
    }
    
    @Operation(summary = "Retorna uma categoria pelo Id")
    @GetMapping("/{id}")
    public ResponseEntity<Categorias> getById(@PathVariable (value = "id") int id){
        var categoria = this.categoriaService.listById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    @Operation(summary = "Deleta uma categoria pelo Id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable (value = "id") int id){
        this.categoriaService.delete(id);
    }

    @Operation(summary = "Salva uma nova categoria no BD")
    @PostMapping
    public ResponseEntity<Categorias> save(@RequestBody @Valid CategoriasDto dto) {
        var categoria = new Categorias();
        BeanUtils.copyProperties(dto, categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoriaService.save(categoria));
    }

    @Operation(summary = "Atualiza uma categoria")
    @PutMapping
    public ResponseEntity<Categorias> update(@PathParam (value = "id") int id, @RequestBody @Valid CategoriasDto dto) {
        var categoria = this.categoriaService.listById(id);
        BeanUtils.copyProperties(dto, categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoriaService.save(categoria));
    }
    
    


}
