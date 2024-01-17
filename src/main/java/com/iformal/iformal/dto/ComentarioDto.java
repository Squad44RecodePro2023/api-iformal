package com.iformal.iformal.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ComentarioDto(
    @NotBlank(message = "O comentário não pode estar vazio")
    @Size(max = 255, message = "O comentário deve ter no máximo 255 caracteres") 
    String comentario,
    
    @NotBlank(message = "O autor não pode estar vazio")
    @Size(max = 55, message = "O autor deve ter no máximo 55 caracteres") 
    String autor,
    
    @NotNull(message = "A nota não pode ser nula") 
    @Min(value = 1, message = "A nota mínima permitida é 1") 
    @Max(value = 5, message = "A nota máxima permitida é 5") 
    int nota
) {
    
}
