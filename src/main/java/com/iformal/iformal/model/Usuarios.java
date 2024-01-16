package com.iformal.iformal.model;

import java.util.Date;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="usuarios")
@Getter 
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column( nullable = false, length = 55)
    private String nome;
    
    @Column( nullable = false, length = 55, unique = true)
    private String email;
    
    @Column( nullable = false, name = "data_nascimento", columnDefinition = "DATE")
    private Date dataNascimento;
    
    @Column( nullable = false, length = 11, columnDefinition = "CHAR(11)")
    private String telefone;
    
    @Column( nullable = false, length = 13, unique = true, columnDefinition = "CHAR(14)")
    private String cpf;

    @Column( nullable = false)
    @Embedded
    Endereco adress = new Endereco();

    @OneToMany(mappedBy = "usuario")
    private List<Avaliacoes> avalicaoes;
    
}
