package com.app.User.aplication.services;

import com.app.User.domain.models.AdicionalTarea;
import com.app.User.domain.models.Tarea;
import com.app.User.domain.ports.in.*;
import com.app.User.infrastructure.entities.TareaEntity;

import java.util.List;
import java.util.Optional;


public class TareaServicio implements CrearTareaUserCase, ActualizarTareaUserCase, EliminarTareaUserCase, RecuperarTareaUserCase, GetAdicionalTareaUserCase {

    private final CrearTareaUserCase crearTareaUserCase;
    private final ActualizarTareaUserCase actualizarTareaUserCase;

    private final EliminarTareaUserCase eliminarTareaUserCase;
    private final RecuperarTareaUserCase recuperarTareaUserCase;
    private final GetAdicionalTareaUserCase getAdicionalTareaUserCase;

    public TareaServicio(CrearTareaUserCase crearTareaUserCase, ActualizarTareaUserCase actualizarTareaUserCase, EliminarTareaUserCase eliminarTareaUserCase, RecuperarTareaUserCase recuperarTareaUserCase, GetAdicionalTareaUserCase getAdicionalTareaUserCase) {
        this.crearTareaUserCase = crearTareaUserCase;
        this.actualizarTareaUserCase = actualizarTareaUserCase;
        this.eliminarTareaUserCase = eliminarTareaUserCase;
        this.recuperarTareaUserCase = recuperarTareaUserCase;
        this.getAdicionalTareaUserCase = getAdicionalTareaUserCase;
    }


    @Override
    public List<TareaEntity> getAllTarea() {
        return recuperarTareaUserCase.getAllTarea();
    }

    @Override
    public Optional<TareaEntity> getTarea(Integer id) {
        return recuperarTareaUserCase.getTarea(id);
    }
    @Override
    public TareaEntity crearTarea(Tarea tarea) {
        return crearTareaUserCase.crearTarea(tarea);
    }

    @Override
    public Optional<TareaEntity> actualizarTarea(Integer id, Tarea actualizarTarea) {
        return actualizarTareaUserCase.actualizarTarea(id, actualizarTarea);
    }

    @Override
    public boolean eliminarTarea(Integer id) {
        return eliminarTareaUserCase.eliminarTarea(id);
    }

    @Override
    public AdicionalTarea getAdicionalTarea(Integer id) {
        return getAdicionalTareaUserCase.getAdicionalTarea(id);
    }


}
