package com.sasor.todoapp.mapper;

import com.sasor.todoapp.dto.in.TaskDto;
import com.sasor.todoapp.persistence.entities.Task;
import com.sasor.todoapp.persistence.entities.TaskStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskDTOToTask implements Mapper<TaskDto, Task>
{

    @Override
    public Task map(TaskDto in)
    {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedAt(LocalDateTime.now());
        task.setFinished(false);
        task.setStatus(TaskStatus.ON_TIME);
        return task;
    }

}
