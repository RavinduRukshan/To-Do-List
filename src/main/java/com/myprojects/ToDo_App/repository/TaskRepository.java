package com.myprojects.ToDo_App.repository;

import com.myprojects.ToDo_App.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
