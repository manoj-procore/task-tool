package com.example.TaskTool.repository;

import com.example.TaskTool.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository extends JpaRepository<Task,Long> {
}
