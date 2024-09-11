package com.example.inventarios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AdminException extends RuntimeException{
    public AdminException(String mensaje){
        super(mensaje);
    }
}
