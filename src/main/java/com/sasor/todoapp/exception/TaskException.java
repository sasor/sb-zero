package com.sasor.todoapp.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class TaskException extends RuntimeException
{
    private String message;
    private HttpStatus httpStatus;

    public TaskException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.httpStatus = status;
    }
}
