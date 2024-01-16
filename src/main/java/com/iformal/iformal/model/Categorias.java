package com.iformal.iformal.model;
import java.util.List;

import jakarta.persistence.Column;
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
@Table(name="categorias")
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
    @OneToMany(mappedBy = "categoria")
    private List<Servicos> servicos;
}
