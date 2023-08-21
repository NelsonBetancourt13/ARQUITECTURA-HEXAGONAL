package com.app.User.infrastructure.controllers;


import com.app.User.aplication.services.TareaServicio;
import com.app.User.domain.models.AdicionalTarea;
import com.app.User.domain.models.Tarea;
import com.app.User.infrastructure.entities.TareaEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarea")
public class TareaController {

    private final TareaServicio tareaServicio;


    public TareaController(TareaServicio tareaServicio) {
        this.tareaServicio = tareaServicio;
    }

    @PostMapping
    public ResponseEntity<TareaEntity>crearTarea(@RequestBody Tarea tarea){
        TareaEntity crearTarea = tareaServicio.crearTarea(tarea);
        return new ResponseEntity<>(crearTarea, HttpStatus.CREATED);
    }

    @GetMapping("/{tareaId}")
    public ResponseEntity<TareaEntity> getTareaId(@PathVariable Integer id){
        return tareaServicio.getTarea(id)
                .map(tarea -> new ResponseEntity<>(tarea,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TareaEntity>>getAllTarea(){
        List<TareaEntity> tareas = tareaServicio.getAllTarea();

        return new ResponseEntity<>(tareas,HttpStatus.OK);
    }

    @PutMapping("/{tareaId}")
    public ResponseEntity<Tarea>actualizarTarea(@PathVariable Integer id, @RequestBody Tarea tarea){
        return tareaServicio.actualizarTarea(id, tarea)
                .map(tarea1 ->  new ResponseEntity<>(tarea,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{tareaId}")
    public ResponseEntity<Void>eliminarTareaId(@PathVariable Integer id){
        if (tareaServicio.eliminarTarea(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{tareaId}/adicionalTarea")
    public ResponseEntity<AdicionalTarea>getAdicionalTarea(@PathVariable Integer id){
        AdicionalTarea adicionalTarea = tareaServicio.getAdicionalTarea(id);
        return new ResponseEntity<>(adicionalTarea,HttpStatus.OK);
    }


}
