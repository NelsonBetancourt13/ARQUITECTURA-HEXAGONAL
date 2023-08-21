package com.app.User.aplication.usecases;

import com.app.User.domain.models.Tarea;
import com.app.User.domain.ports.in.CrearTareaUserCase;
import com.app.User.domain.ports.out.TareaRepositorioPuerto;
import com.app.User.infrastructure.entities.TareaEntity;

public class CrearTareaUserCaseImpl implements CrearTareaUserCase {

    private final TareaRepositorioPuerto tareaRepositorioPuerto;


    public CrearTareaUserCaseImpl(TareaRepositorioPuerto tareaRepositorioPuerto) {
        this.tareaRepositorioPuerto = tareaRepositorioPuerto;
    }

    @Override
    public TareaEntity crearTarea(Tarea tarea) {
        return tareaRepositorioPuerto.guardar(tarea);
    }
}
