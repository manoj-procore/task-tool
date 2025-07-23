package com.example.TaskTool.repository;

import com.example.TaskTool.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;

@RequestBody
public class TaskRepository extends JpaRepository<Comment,Long> {

}
