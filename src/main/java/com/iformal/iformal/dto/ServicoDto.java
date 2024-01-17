package com.iformal.iformal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ServicoDto(
     @NotBlank(message = "O nome não pode estar vazio") 
     @Size(max = 55, message = "O nome deve ter no máximo 55 caracteres") 
     String nome,
     @NotBlank(message = "A descrição não pode estar vazia") 
     @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres") 
     String descricao,
     @NotNull(message = "A categoria não pode ser nula") Long categoriaId
) {
    
}
