package com.example.springboot1.error;


import com.example.springboot1.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * We are creating a method that is responsible for handling
 * certain kind of exception.
 *
 * We currently have found this kind of exception , so
 * we will create a method that will handle this exception.
 */
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)

    // This method is handling departmentNotFoundException over here.
    // Passing exception and WebRequest as parameter.

    // This is how we are handling exception in SpringBoot.
    public ResponseEntity<ErrorMessage> departmentNotFoundException(
            DepartmentNotFoundException exception , WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND , exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
