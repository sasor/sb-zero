package com.sasor.todoapp.persistence.repositories;

import com.sasor.todoapp.persistence.entities.Task;
import com.sasor.todoapp.persistence.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>
{
    public List<Task> findAllByStatus(TaskStatus status);
}
