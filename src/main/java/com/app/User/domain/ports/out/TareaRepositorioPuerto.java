package com.app.User.domain.ports.out;

import com.app.User.domain.models.Tarea;
import com.app.User.infrastructure.entities.TareaEntity;

import java.util.List;
import java.util.Optional;

public interface TareaRepositorioPuerto {

    TareaEntity guardar(Tarea tarea);
    Optional<TareaEntity> findById(Integer id);
    List<TareaEntity> findAll();
    Optional<TareaEntity> actualizar(Tarea tarea);
    boolean eliminarById(Integer id);

}
