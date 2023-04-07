package com.sasor.todoapp.dto.in;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDto
{
    public String title;
    public String description;
    public LocalDateTime eta;
}
