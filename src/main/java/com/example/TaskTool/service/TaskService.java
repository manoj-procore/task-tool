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

    public Task save(Task task)
    {
        task.setCreatedAt(OffsetDateTime.now());
        task.setUpdatedAt(OffsetDateTime.now());
        return taskRepository.save(task);

    }

    public Optional<Task> getById(Long id)
    {
        return taskRepository.findById(id);
    }

    public Task updateTask(Long id, Task task) {
        Task t = taskRepository.findById(id).orElse(null);
        if (t != null) {
            if (task.getDescription() != null && !task.getDescription().isEmpty()) {
                t.setDescription(task.getDescription());
            }

            if (task.getNumber() != null && !task.getNumber().isEmpty()) {
                t.setNumber(task.getNumber());
            }

            if (task.getAssignee() != null && !task.getAssignee().isEmpty()) {
                t.setAssignee(task.getAssignee());
            }

            if (task.getDescriptionRichText() != null && !task.getDescriptionRichText().isEmpty()) {
                t.setDescriptionRichText(task.getDescriptionRichText());
            }

            if (task.getTitle() != null && !task.getTitle().isEmpty()) {
                t.setTitle(task.getTitle());
            }

            if (task.getDueDate() != null) {
                t.setDueDate(task.getDueDate());
            }

            if (task.getPriority() != null && !task.getPriority().isEmpty()) {
                t.setPriority(task.getPriority());
            }

            t.setUpdatedAt(OffsetDateTime.now());
            taskRepository.save(t);
        }

        return t;
    }


    public Boolean deleteTask(Long id)
    {
        Task t=taskRepository.findById(id).orElse(null);
        if(t!=null)
        {
            t.setDeletedAt(OffsetDateTime.now());
            taskRepository.deleteById(id);
            return true;

        }
        return false;

    }

    public Boolean addComment(Comment comment) {
         comment.setCreatedAt(OffsetDateTime.now());
         comment.setUpdatedAt(OffsetDateTime.now());
         commentRepository.save(comment);
         return true;
    }

    public List<Comment> getComments(Long taskId) {
       return commentRepository.findByTaskItemId(taskId);
    }

}
