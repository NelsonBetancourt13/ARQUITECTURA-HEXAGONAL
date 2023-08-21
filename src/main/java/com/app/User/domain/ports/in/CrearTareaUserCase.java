package com.app.User.domain.ports.in;

import com.app.User.domain.models.Tarea;
import com.app.User.infrastructure.entities.TareaEntity;

public interface CrearTareaUserCase {

    TareaEntity crearTarea(Tarea tarea);
}
