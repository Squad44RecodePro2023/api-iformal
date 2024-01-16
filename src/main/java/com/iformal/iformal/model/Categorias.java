package com.iformal.iformal.model;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
@Table(name="usuarios")
@Getter 
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Categorias {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( nullable = false, length = 55, unique = true)
    private String nome;
    @Column( nullable = false, length = 255)
    private String descricao;
}
