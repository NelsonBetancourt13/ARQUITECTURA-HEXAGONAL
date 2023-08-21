package com.app.User.aplication.usecases;

import com.app.User.domain.models.Tarea;
import com.app.User.domain.ports.in.ActualizarTareaUserCase;
import com.app.User.domain.ports.out.TareaRepositorioPuerto;
import com.app.User.infrastructure.entities.TareaEntity;

import java.util.Optional;

public class ActualizarTareaUserCaseImpl implements ActualizarTareaUserCase {

    private final TareaRepositorioPuerto tareaRepositorioPuerto;

    public ActualizarTareaUserCaseImpl(TareaRepositorioPuerto tareaRepositorioPuerto) {
        this.tareaRepositorioPuerto = tareaRepositorioPuerto;
    }


    @Override
    public Optional<TareaEntity> actualizarTarea(Integer id, Tarea actualizarTarea) {
        return tareaRepositorioPuerto.actualizar(actualizarTarea);
    }
}
