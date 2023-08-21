package com.app.User.aplication.usecases;

import com.app.User.domain.ports.in.EliminarTareaUserCase;
import com.app.User.domain.ports.out.TareaRepositorioPuerto;

public class EliminarTareaUserCaseImpl implements EliminarTareaUserCase {

    private final TareaRepositorioPuerto tareaRepositorioPuerto;

    public EliminarTareaUserCaseImpl(TareaRepositorioPuerto tareaRepositorioPuerto) {
        this.tareaRepositorioPuerto = tareaRepositorioPuerto;
    }


    @Override
    public boolean eliminarTarea(Integer id) {
        return tareaRepositorioPuerto.eliminarById(id);
    }
}
