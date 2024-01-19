package com.iformal.iformal.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="avaliacao_prestador")
@Getter 
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Avaliacoes {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column( length = 255)
    private String comentario;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private int nota;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    @JsonManagedReference
    private Usuarios usuario;

    
    @ManyToOne
    @JoinColumn(name = "prestador_id")
    @JsonManagedReference
    private Prestador prestador;

    
}
