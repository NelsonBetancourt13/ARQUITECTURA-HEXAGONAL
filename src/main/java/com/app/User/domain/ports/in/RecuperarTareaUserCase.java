package com.app.User.domain.ports.in;

import com.app.User.infrastructure.entities.TareaEntity;

import java.util.List;
import java.util.Optional;

public interface RecuperarTareaUserCase {

    Optional<TareaEntity> getTarea(Integer id);
    List<TareaEntity> getAllTarea();
}
