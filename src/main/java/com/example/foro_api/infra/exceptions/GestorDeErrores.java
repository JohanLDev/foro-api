package com.example.foro_api.infra.exceptions;

import com.example.foro_api.domain.ValidacionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GestorDeErrores {

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity gestionarErrorValidacion(ValidacionException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
