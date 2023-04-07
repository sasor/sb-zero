package com.sasor.todoapp.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String title;
    public String description;
    public LocalDateTime createdAt;
    public LocalDateTime eta;
    public boolean finished;
    public TaskStatus status;
}
