package com.myprojects.ToDo_App.controller;

import com.myprojects.ToDo_App.model.Status;
import com.myprojects.ToDo_App.model.Task;
import com.myprojects.ToDo_App.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Display all tasks in HTML table
    @GetMapping("/list")
    public String getAllTasks(Model theModel) {
        List<Task> theTasks = taskService.findAll();
        theModel.addAttribute("tasks", theTasks);
        return "tasks/list-tasks";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Task theTask = new Task();
        theModel.addAttribute("tasks", theTask);
        return "tasks/task-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("taskId") Long theId, Model theModel) {
        Task theTask = taskService.findById(theId);
        theModel.addAttribute("tasks", theTask);
        return "tasks/task-form";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute("tasks") Task theTask) {
        taskService.save(theTask);
        return "redirect:/tasks/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("taskId") Long theId) {
        taskService.deleteById(theId);
        return "redirect:/tasks/list";
    }

    @GetMapping("/updateStatus")
    public String updateStatus(@RequestParam("taskId") Long taskId, @RequestParam("status") Status status) {
        taskService.updateTaskStatus(taskId, status);
        return "redirect:/tasks/list";
    }

}
