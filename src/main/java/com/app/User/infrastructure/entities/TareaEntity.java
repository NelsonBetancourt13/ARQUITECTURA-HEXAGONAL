package com.app.User.infrastructure.entities;


import com.app.User.domain.models.Tarea;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class TareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descripcion;
    private LocalDateTime creacionDate;
    private boolean completado;

    public TareaEntity(){
    }


    public TareaEntity(Integer id, String titulo, String descripcion, LocalDateTime creacionDate, boolean completado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.creacionDate = creacionDate;
        this.completado = completado;
    }

    public static TareaEntity fromDomainModel(Tarea tarea){
        return new TareaEntity(tarea.id,tarea.titulo,tarea.descripcion,tarea.creacionDate,tarea.completado);

    }

    public TareaEntity toDomainModel(){
        return new TareaEntity(id,titulo,descripcion,creacionDate,completado);
    }


}
