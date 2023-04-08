package com.sasor.todoapp.persistence.repositories;

import com.sasor.todoapp.persistence.entities.Task;
import com.sasor.todoapp.persistence.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>
{
    public List<Task> findAllByStatus(TaskStatus status);

    @Modifying
    @Query(value = "UPDATE tasks SET finished=true WHERE id=:id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
}

//    @Modifying
//    @Query("UPDATE user SET (verified = 1 WHERE verified=0)")
//    public void verifyUser();