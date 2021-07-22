package com.springboot.template.application.exception;

import com.springboot.template.core.response.ErrorResponse;
import com.springboot.template.domain.exception.UserAlreadyExistsException;
import com.springboot.template.domain.exception.UserNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApiExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleUserAlreadyExists(UserAlreadyExistsException exception) {
        return new ErrorResponse(HttpStatus.CONFLICT, "Auth-001", exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFound(UserNotFoundException exception) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, "Auth-002", exception.getMessage());
    }
}
