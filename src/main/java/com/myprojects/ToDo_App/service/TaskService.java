package com.myprojects.ToDo_App.service;

import com.myprojects.ToDo_App.model.Status;
import com.myprojects.ToDo_App.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findById(Long theId);

    void save(Task theTask);

    void deleteById(Long theId);

    void updateTaskStatus(Long id, Status status);

}
