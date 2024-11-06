package com.empresa.cruddeforestacionapi.exceptions;

public class RecursoNoEncontradoExcepcion extends RuntimeException{

    public RecursoNoEncontradoExcepcion(String mensaje){
        super(mensaje);
    }
}
