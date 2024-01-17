package com.iformal.iformal.services;

import java.util.List;
import com.iformal.iformal.model.Prestador;

public interface IPrestadorService {
    Prestador save(Prestador prestador);
    Prestador update(Prestador prestador);
    void delete(int prestadorId);
    List<Prestador> listAll();
    Prestador listById(int prestadorId);
}
