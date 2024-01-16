package com.iformal.iformal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter 
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Endereco {
    
    @Column( nullable = false, length = 55)
    private String logradouro;
    @Column(nullable = false)
    private int numero;
    @Column( nullable = false, length = 55)
    private String bairro;
    @Column( nullable = false, length = 9 )
    private String cep;
    @Column( nullable = false, length = 15)
    private String complemento;
    @Column( nullable = false, length = 2)
    private String estado;
    @Column( nullable = false, length = 55)
    private String cidade;
    
}
