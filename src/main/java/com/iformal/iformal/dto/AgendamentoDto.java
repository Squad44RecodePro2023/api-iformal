package com.iformal.iformal.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

public record AgendamentoDto(
    @NotNull(message="A data não pode ser nula")
    Date data,
    @NotNull(message="O valor não pode ser nulo")
    Float valor,
    @NotNull(message="O prestador não pode ser nulo")
    Long prestadorId,
    @NotNull(message="O usuário não pode ser nulo")
    Long usuarioId,
    @NotNull(message="O servico não pode ser nulo")
    Long servicoId
    )
{

}
