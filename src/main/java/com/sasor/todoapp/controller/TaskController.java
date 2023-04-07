package com.sasor.todoapp.controller;

import com.sasor.todoapp.dto.in.TaskDto;
import com.sasor.todoapp.persistence.entities.Task;
import com.sasor.todoapp.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController
{
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDto payload)
    {
        return this.service.createTask(payload);
    }
}
