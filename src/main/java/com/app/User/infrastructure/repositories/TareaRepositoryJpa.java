package com.app.User.infrastructure.repositories;

import com.app.User.infrastructure.entities.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepositoryJpa extends JpaRepository<TareaEntity, Integer> {
}
