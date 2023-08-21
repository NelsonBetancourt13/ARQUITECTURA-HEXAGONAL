package com.app.User.aplication.usecases;


import com.app.User.domain.ports.in.RecuperarTareaUserCase;
import com.app.User.domain.ports.out.TareaRepositorioPuerto;
import com.app.User.infrastructure.entities.TareaEntity;

import java.util.List;
import java.util.Optional;

public class RecuperarTareaUserCaseImpl implements RecuperarTareaUserCase {


    private final TareaRepositorioPuerto tareaRepositorioPuerto;


    public RecuperarTareaUserCaseImpl(TareaRepositorioPuerto tareaRepositorioPuerto) {
        this.tareaRepositorioPuerto = tareaRepositorioPuerto;
    }

    @Override
    public Optional<TareaEntity> getTarea(Integer id) {
        return tareaRepositorioPuerto.findById(id);
    }

    @Override
    public List<TareaEntity> getAllTarea() {
        return tareaRepositorioPuerto.findAll();
    }
}
