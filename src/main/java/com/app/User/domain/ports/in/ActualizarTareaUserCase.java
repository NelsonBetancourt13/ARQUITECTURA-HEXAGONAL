package com.app.User.domain.ports.in;

import com.app.User.domain.models.Tarea;
import com.app.User.infrastructure.entities.TareaEntity;

import java.util.Optional;

public interface ActualizarTareaUserCase {

    Optional<TareaEntity> actualizarTarea(Integer id, Tarea actualizarTarea);

}
