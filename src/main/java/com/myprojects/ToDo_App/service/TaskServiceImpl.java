package com.myprojects.ToDo_App.service;

import com.myprojects.ToDo_App.model.Task;
import com.myprojects.ToDo_App.model.Status;
import com.myprojects.ToDo_App.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {


    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository theTaskRepository) {
        taskRepository = theTaskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long theId) {
        Optional<Task> result = taskRepository.findById(theId);

        Task theTask = null;

        if (result.isPresent()) {
            theTask = result.get();
        } else {
            throw new RuntimeException("Did not find Task id - " + theId);
        }
        return theTask;
    }

    @Override
    public void save(Task theTask) {
        taskRepository.save(theTask);
    }

    @Override
    public void deleteById(Long theId) {
        taskRepository.deleteById(theId);
    }

    @Override
    public void updateTaskStatus(Long id, Status status) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task theTask = taskOptional.get();
            theTask.setStatus(status);
            taskRepository.save(theTask); // Save updated task
        } else {
            throw new RuntimeException("Task not found with id - " + id);
        }
    }


    // Update Task Status
//    public Task updateTaskStatus(Long id, Status status) {  // Use Status enum after import
//        Optional<Task> taskOptional = taskRepository.findById(id);
//        if (taskOptional.isPresent()) {
//            Task task = taskOptional.get();
//            task.setStatus(status);
//            return taskRepository.save(task);
//        }
//        return null;
//    }

}
