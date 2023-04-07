package com.sasor.todoapp.persistence.repositories;

import com.sasor.todoapp.persistence.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>
{}
