package com.scd.oscarvalenzuela.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CompositorNoEncontradoExcepcion extends RuntimeException{

    public CompositorNoEncontradoExcepcion(String mensaje){
        super(mensaje);
    }
}
