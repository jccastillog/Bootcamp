package com.empresa.cruddeforestacionapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejadorGlobalExcepcion {
    @ExceptionHandler(RecursoNoEncontradoExcepcion.class)
    public ResponseEntity<?> manejadorRecursoNoEncontrado(RecursoNoEncontradoExcepcion rescursoNoEncontradoExcepcion){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rescursoNoEncontradoExcepcion.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejadorExcepcionGlobal(Exception exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
    }

}
