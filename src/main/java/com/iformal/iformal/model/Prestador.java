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
@Table(name="prestador")
@Getter 
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Prestador {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( nullable = false, length = 11)
    private String contato;
    

    
}
