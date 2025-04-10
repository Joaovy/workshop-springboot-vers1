package com.projectWebService.webService.resource.exceptions;


import com.projectWebService.webService.services.exceptions.DatabaseException;
import com.projectWebService.webService.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

// Anotação que permite tratar exceções de forma global em todos os controladores REST da aplicação
@ControllerAdvice
public class ResourceExceptionHandler {
    // Metodo que será chamado automaticamente quando ocorrer uma exceção do tipo ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){

        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        // Cria um objeto de erro padrão com as informações da exceção e da requisição
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        // Retorna a resposta HTTP com o status definido e o corpo contendo o objeto de erro
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> dataBase(DatabaseException e, HttpServletRequest request){

        String error = "Dadabase error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        // Cria um objeto de erro padrão com as informações da exceção e da requisição
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        // Retorna a resposta HTTP com o status definido e o corpo contendo o objeto de erro
        return ResponseEntity.status(status).body(err);
    }


}
