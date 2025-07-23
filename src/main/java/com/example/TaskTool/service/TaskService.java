package com.example.TaskTool.service;

import com.example.TaskTool.model.Comment;
import com.example.TaskTool.model.Task;
import com.example.TaskTool.repository.CommentRepository;
import com.example.TaskTool.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Autowired
    private CommentRepository commentRepository;

    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();

    }

    public void save(Task task)
    {
        task.setCreatedAt(OffsetDateTime.now());
        task.setUpdatedAt(OffsetDateTime.now());
        taskRepository.save(task);
    }

    public Optional<Task> getById(Long id)
    {
        return taskRepository.findById(id);
    }

    public  Task updateTask( Long id,Task task)
    {
        Task t=taskRepository.findById(id).orElse(null);
        if(t!=null)
        {
            t.setDescription(t.getDescription().isEmpty()?task.getDescription():t.getDescription());
            t.setNumber(t.getNumber().isEmpty()?task.getNumber():t.getNumber());
            t.setAssignee(t.getAssignee().isEmpty()?task.getAssignee():t.getAssignee());
            task.setUpdatedAt(OffsetDateTime.now());
            t.setDescriptionRichText(t.getDescriptionRichText().isEmpty()?task.getDescriptionRichText():t.getDescriptionRichText());
            t.setDescription(task.getDescription().isEmpty()?task.getDescription():t.getDescription());
            t.setTitle(task.getTitle().isEmpty()?task.getTitle():t.getTitle());
            t.setDueDate(task.getDueDate());
            t.setPriority(task.getPriority().isEmpty()?task.getPriority():t.getPriority());
            taskRepository.save(t);
        }

        return t;
    }

    public void deleteTask(Long id)
    {
        Task t=taskRepository.findById(id).orElse(null);
        if(t!=null)
        {
            t.setDeletedAt(OffsetDateTime.now());
            taskRepository.deleteById(id);

        }

    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }


}
