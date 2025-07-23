package com.example.TaskTool.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/task_items")
public class TaskController {

    @GetMapping
    public List<TaskItems> getTasks()
    {
        return taskService.getAll();
    }

    @PostMapping
    public void createTask(@RequestBody TaskItems task)
    {
         taskService.save(task);
    }

    @GetMapping("/task/{id}")
    public TaskItems getTask(@PathVariable Long id){

        return taskService.getById(id);
    }

    @PutMapping("/task/{id}")
    public void updateTask(@PathVariable Long id,@RequestBody TaskItems task)
    {

    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable Long id)
    {
        return taskService.deleteById(id);
    }


}
