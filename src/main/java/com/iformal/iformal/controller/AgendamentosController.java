package com.iformal.iformal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.iformal.iformal.dto.AgendamentoDto;
import com.iformal.iformal.model.Agendamentos;
import com.iformal.iformal.services.impl.AgendamentoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin("http://localhost:3000/")

public class AgendamentosController {

    @Autowired
    AgendamentoService agendamentoService;

    @Operation(summary = "Retorna o agendamento atravéz do id")
    @GetMapping("/{id}")
    public ResponseEntity<Agendamentos> getById(@PathVariable(value = "id") int id) {
        var agendamento = this.agendamentoService.listById(id);
        return ResponseEntity.status(HttpStatus.OK).body(agendamento);
    }

    @Operation(summary = "Retorna uma lista de agendamentos a partir do id do prestador")
    @GetMapping("/prestador_id/{id}")
    public ResponseEntity<List<Agendamentos>> getByPrestadorId(@PathVariable(value = "id") int id) {
        var agendamento = this.agendamentoService.listAllByPrestador(id);
        return ResponseEntity.status(HttpStatus.OK).body(agendamento);
    }

    @Operation(summary = "Retorna uma lista de agendamentos a partir do id do Usuario")
    @GetMapping("/usuario_id/{id}")
    public ResponseEntity<List<Agendamentos>> getByUsuarioId(@PathVariable(value = "id") int id) {
        var agendamento = this.agendamentoService.listAllByUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(agendamento);
    }

    @Operation(summary = "Deleta um Agendamento a partir de um id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(value = "id") int id) {
        this.agendamentoService.delete(id);
    }

    @Operation(summary = "Salva um novo agendamento no BD")
    @PostMapping()
    public ResponseEntity<Agendamentos> save(@RequestBody @Valid AgendamentoDto agendamentoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.agendamentoService.save(agendamentoDto));
    }

    @Operation(summary = "Atualiza um agendamento no BD")
    @PutMapping
    public ResponseEntity<Agendamentos> update(@PathParam (value = "id") int id, @RequestBody @Valid AgendamentoDto agendamentoDto)
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.agendamentoService.update(agendamentoDto, id));
    }

}
