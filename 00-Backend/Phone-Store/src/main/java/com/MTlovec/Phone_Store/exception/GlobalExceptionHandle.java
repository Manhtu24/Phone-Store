package com.MTlovec.Phone_Store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException exception){
        ExceptionResponse errResponse=new ExceptionResponse(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleAlreadyExistException(AlreadyExistException exception){
        ExceptionResponse errResponse=new ExceptionResponse(HttpStatus.CONFLICT.value(),
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<ExceptionResponse> handleGlobalExceptionException(Exception ex){
        ExceptionResponse errResponse=new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errResponse,HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
