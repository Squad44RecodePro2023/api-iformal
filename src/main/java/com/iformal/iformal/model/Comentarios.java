package com.iformal.iformal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="comentarios")
@Getter 
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comentarios {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;    
    @Column( nullable = false, length = 255)
    private String comentario;
    @Column (nullable = false, length = 55)
    private String autor;
    @Column(nullable = false, columnDefinition = "TINYINT")
    private int nota;
}
