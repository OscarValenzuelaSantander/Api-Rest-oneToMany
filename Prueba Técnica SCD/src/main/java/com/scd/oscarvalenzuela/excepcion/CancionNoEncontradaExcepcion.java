package com.scd.oscarvalenzuela.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CancionNoEncontradaExcepcion extends RuntimeException{

    public CancionNoEncontradaExcepcion(String mensaje){
        super(mensaje);
    }
}
