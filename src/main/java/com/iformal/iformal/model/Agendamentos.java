package com.iformal.iformal.model;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="agendamentos",
 indexes = {@Index(name = "index_agendamento_unico", columnList = "data,prestador_id", unique = true)})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agendamentos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private Date data;
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private float valor;
    @ManyToOne
    @JoinColumn(name="prestador_id")
    private Prestador prestador;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuarios usuario;    
    @ManyToOne
    @JoinColumn(name="servico_id")
    private Servicos servico;          
}
