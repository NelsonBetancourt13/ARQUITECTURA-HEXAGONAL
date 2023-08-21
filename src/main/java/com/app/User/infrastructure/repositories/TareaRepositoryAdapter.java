package com.app.User.infrastructure.repositories;

import com.app.User.domain.models.Tarea;
import com.app.User.domain.ports.out.TareaRepositorioPuerto;
import com.app.User.infrastructure.entities.TareaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class TareaRepositoryAdapter implements TareaRepositorioPuerto {

    private final TareaRepositoryJpa tareaRepositoryJpa;

    public TareaRepositoryAdapter(TareaRepositoryJpa tareaRepositoryJpa) {
        this.tareaRepositoryJpa = tareaRepositoryJpa;
    }


    @Override
    public List<TareaEntity> findAll() {
        return tareaRepositoryJpa.findAll().stream().map(TareaEntity::toDomainModel).collect(Collectors.toList());
    }


    @Override
    public Optional<TareaEntity> findById(Integer id) {
        return tareaRepositoryJpa.findById(id).map(TareaEntity::toDomainModel);
    }

    @Override
    public TareaEntity guardar(Tarea tarea) {
        TareaEntity tareaEntity = TareaEntity.fromDomainModel(tarea);
        TareaEntity guardarTareaEntity= tareaRepositoryJpa.save(tareaEntity);
        return guardarTareaEntity.toDomainModel();
    }


    @Override
    public Optional<TareaEntity> actualizar(Tarea tarea) {
        if (tareaRepositoryJpa.existsById(tarea.id)){
            TareaEntity tareaEntity= TareaEntity.fromDomainModel(tarea);
            TareaEntity actualizarTarea = tareaRepositoryJpa.save(tareaEntity);
            return Optional.of(actualizarTarea.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean eliminarById(Integer id) {

        if (tareaRepositoryJpa.existsById(id)){
            tareaRepositoryJpa.deleteById(id);
            return true;
        }
        return false;
    }
}
