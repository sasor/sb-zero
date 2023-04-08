package com.sasor.todoapp.service;

import com.sasor.todoapp.dto.in.TaskDto;
import com.sasor.todoapp.exception.TaskException;
import com.sasor.todoapp.mapper.TaskDTOToTask;
import com.sasor.todoapp.persistence.entities.Task;
import com.sasor.todoapp.persistence.entities.TaskStatus;
import com.sasor.todoapp.persistence.repositories.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService
{
    private final TaskRepository taskRepository;
    private final TaskDTOToTask toTaskMapper;

    public TaskService(TaskRepository taskRepository, TaskDTOToTask toTaskMapper)
    {
        this.taskRepository = taskRepository;
        this.toTaskMapper = toTaskMapper;
    }

    public Task createTask(TaskDto dto)
    {
        Task task = this.toTaskMapper.map(dto);
        return this.taskRepository.save(task);
    }

    public List<Task> findAll()
    {
        return this.taskRepository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status)
    {
        return this.taskRepository.findAllByStatus(status);
    }

    @Transactional
    public void markTaskAsFinished(Long id)
    {
        Optional<Task> task = this.taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new TaskException("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.markTaskAsFinished(id);
    }
}
