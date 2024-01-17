package com.iformal.iformal.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AvaliacaoesDto(
        @Size(max = 255, message = "O comentário deve ter no máximo 255 caracteres") 
        String comentario,
        @NotNull(message = "A nota não pode ser nula") 
        @Min(value = 1, message = "A nota mínima permitida é 1") 
        @Max(value = 5, message = "A nota máxima permitida é 5") 
        int nota,
        @NotNull(message = "O usuário não pode ser nulo") 
        Long usuarioId,
        @NotNull(message = "O prestador não pode ser nulo") 
        Long prestadorId
        ) {

}
