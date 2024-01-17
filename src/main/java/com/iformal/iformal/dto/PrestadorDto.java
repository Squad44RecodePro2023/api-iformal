package com.iformal.iformal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PrestadorDto(
        @NotBlank(message = "O contato não pode estar em branco") 
        @Size(min =11, max = 11, message = "O contato deve ter 11 caracteres")  
        @Pattern(regexp = "\\d{11}", message = "O Contato deve conter apenas números e ter 11 dígitos") 
        String contato,
        @NotBlank(message = "As especialidades não podem estar em branco") 
        @Size(max = 255, message = "As especialidades devem ter no máximo 255 caracteres") 
        String especialidades,
        @NotNull(message = "O usuário não pode ser nulo") 
        Long usuarioId
        ) {

}
