package com.sasor.todoapp.controller;

import com.sasor.todoapp.dto.in.TaskDto;
import com.sasor.todoapp.persistence.entities.Task;
import com.sasor.todoapp.persistence.entities.TaskStatus;
import com.sasor.todoapp.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Task> findAll()
    {
        return this.service.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus status)
    {
        return this.service.findAllByTaskStatus(status);
    }

    @PatchMapping("/{id}/finished")
    public ResponseEntity<Void> updateTaskAsFinished(@PathVariable("id") Long id)
    {
        this.service.markTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }
}
