package com.iformal.iformal.controller;

import org.springframework.web.bind.annotation.RestController;

import com.iformal.iformal.dto.PrestadorDto;
import com.iformal.iformal.model.Prestador;
import com.iformal.iformal.services.impl.PrestadorService;
import com.iformal.iformal.services.impl.UsuariosService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/prestadores")
public class PrestadorController {
    @Autowired
    PrestadorService prestadorService;
    @Autowired
    UsuariosService usuariosService;

    @Operation(summary = "Retorna uma lista de prestadores")
    @GetMapping()
    public ResponseEntity<List<Prestador>> getAllPretador(){
        List<Prestador> prestadorList = this.prestadorService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(prestadorList);
    }


    @Operation(summary = "Retorna um prestador atravéz do id")
    @GetMapping("/{id}")
    public ResponseEntity<Prestador> getPrestadorById(@PathVariable (value = "id") int id) {
        Prestador prestador = prestadorService.listById(id);
        return ResponseEntity.status(HttpStatus.OK).body(prestador);
    }


    @Operation(summary = "Delte um pretador atravéz do id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePrestadorById(@PathParam (value = "id") int id){
        this.prestadorService.delete(id);
    }

    @Operation(summary = "Salva um novo prestador")
    @PostMapping()
    public ResponseEntity<Prestador> savePrestador(@RequestBody @Valid PrestadorDto prestadorDto) {
        var prestador = new Prestador();
        var user = this.usuariosService.listById(prestadorDto.usuarioId());
        BeanUtils.copyProperties(prestadorDto, prestador);
        prestador.setUsuario(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.prestadorService.save(prestador));
    }

    @Operation(summary = "Atualiza um prestador")
    @PutMapping()
    public ResponseEntity<Prestador> updatePrestador(@PathParam (value = "id") int id, @RequestBody @Valid PrestadorDto prestadorDto) {
        var prestador = this.prestadorService.listById(id);
        BeanUtils.copyProperties(prestadorDto, prestador);
        return ResponseEntity.status(HttpStatus.OK).body(this.prestadorService.update(prestador));
    }

}
