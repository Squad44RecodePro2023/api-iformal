package com.iformal.iformal.controller;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iformal.iformal.dto.AvaliacaoesDto;
import com.iformal.iformal.model.Avaliacoes;
import com.iformal.iformal.services.impl.AvaliacoesService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/avalicaoes")

@CrossOrigin("http://localhost:3000/")
public class AvaliacaoController {

    @Autowired
    AvaliacoesService avaliacoesService;

    @Operation( summary = "Retorna uma avaliação pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<Avaliacoes> getbyId(@PathVariable (value = "id") int id){        
        var avaliacaoList = this.avaliacoesService.listById(id);
        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoList);
    }
    
    @Operation(summary="Retorna uma lista de avaliações pelo id do prestador")
    @GetMapping("/prestador/{id}")
    public ResponseEntity<List<Avaliacoes>> getAllByPrestador(@PathVariable (value = "id") int id){        
        var avaliacaoList = this.avaliacoesService.listAllByPrestador(id);
        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoList);
    }
    
    @Operation(summary="Retorna uma lista de avaliações pelo id do usuario")
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Avaliacoes>> getAllByUsuario(@PathVariable (value = "id") int id){        
        var avaliacaoList = this.avaliacoesService.listAllByUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoList);
    }
    

    @Operation(summary = "Deleta uma avaliação pelo id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable (value = "id") int id){
        this.avaliacoesService.delete(id);
    }

    @Operation(summary = "Salva uma Avaliação no banco de dados")
    @PostMapping()
    public ResponseEntity<Avaliacoes> save(@RequestBody @Valid AvaliacaoesDto dto) {    
        return ResponseEntity.status(HttpStatus.CREATED).body(this.avaliacoesService.save(dto));
    }


    @Operation(summary = "Atualiza uma Avaliação no banco de dados")
    @PutMapping()
    public ResponseEntity<Avaliacoes> update(@PathParam (value = "id") int id, @RequestBody @Valid AvaliacaoesDto dto) {    
        return ResponseEntity.status(HttpStatus.OK).body(this.avaliacoesService.update(dto, id));
    }

    
}
