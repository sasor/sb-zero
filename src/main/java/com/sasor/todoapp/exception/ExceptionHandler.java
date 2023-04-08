package com.sasor.todoapp.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler
{
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {TaskException.class})
    protected ResponseEntity<Object> handle(TaskException exception, WebRequest request)
    {
        String responseBody = exception.getMessage();
        return handleExceptionInternal(exception, responseBody, new HttpHeaders(), exception.getHttpStatus(), request);
    }
}
