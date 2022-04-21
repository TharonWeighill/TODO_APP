package com.example.todo_app.Repo;
import com.example.todo_app.Models.TodoLists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<TodoLists, Long> {
}
