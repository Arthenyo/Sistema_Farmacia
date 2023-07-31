package com.example.SistemaDeFarmacia.Controleres.handler;

import com.example.SistemaDeFarmacia.DTO.CustomErro;
import com.example.SistemaDeFarmacia.Servicies.exceptions.DataBaseException;
import com.example.SistemaDeFarmacia.Servicies.exceptions.ResourceNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<CustomErro> resourceNotFound(ResourceNotFound e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NO_CONTENT;
        CustomErro err = new CustomErro(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<CustomErro> dataBaseException(DataBaseException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomErro err = new CustomErro(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
