package com.iformal.iformal.dto;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioDto(
        @NotBlank(message = "O nome não pode estar vazio, por favor insira um nome válido") 
        String nome,
        @NotBlank(message = "O email não pode estar vazio, por favor insira um email válido.") 
        @Email(message = "Email inválido.") 
        String email,
        @Past(message = "Ano de nascimento inválido") 
        @NotNull(message = "O ano de nascimento não poder ser nulo") 
        @Min(value = 1900, message = "Ano de nascimento inválido") 
        Date dataNascimento,
        @Size(min = 11, max = 11, message = "O telefone deve ter 11 digitos")
        @Pattern(regexp = "\\d{11}", message = "O telefone deve conter apenas números e ter 11 dígitos") 
        String telefone,
        @NotNull(message = "o cpf não pode ser nulo") 
        @CPF String cpf,
        @NotBlank(message = "O logradouro não pode estar em branco") 
        @Size(max = 55, message = "O logradouro deve ter no máximo 55 caracteres") 
        String logradouro,
        @NotNull(message = "O número não pode ser nulo") 
        int numero,
        @NotBlank(message = "O bairro não pode estar em branco") 
        @Size(max = 55, message = "O bairro deve ter no máximo 55 caracteres") 
        String bairro,
        @NotBlank(message = "O CEP não pode estar em branco") 
        @Size(min = 9, max = 9, message = "O CEP deve ter 9 caracteres") 
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP brasileiro deve ter o formato XXXXX-XXX") 
        String cep,
        @Size(max = 15, message = "O complemento deve ter no máximo 15 caracteres") 
        String complemento,
        @NotBlank(message = "O estado não pode estar em branco") 
        @Size(min = 2, max = 2, message = "O estado deve ter 2 caracteres") 
        String estado,
        @NotBlank(message = "A cidade não pode estar em branco") 
        @Size(max = 55, message = "A cidade deve ter no máximo 55 caracteres") 
        String cidade

) {

}
