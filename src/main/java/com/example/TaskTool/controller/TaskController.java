package com.example.TaskTool.controller;
import com.example.TaskTool.model.Task;
import com.example.TaskTool.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest/v1/task_items")
public class TaskController {

     @Autowired
     private TaskService taskService;

    @GetMapping
    public List<Task> getTasks()
    {
        return taskService.getAllTasks();
    }

    @PostMapping
    public void createTask(@RequestBody Task task)
    {
         taskService.save(task);
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable Long id){
        return taskService.getById(id).orElse(null);
    }

    @PutMapping("/task/{id}")
    public Task updateTask(@PathVariable Long id,@RequestBody Task task)
    {
     return  taskService.updateTask(id, task);

    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable Long id)
    {
         taskService.deleteTask(id);
    }


}
