package com.example.todo_app.Service;

import com.example.todo_app.Models.TodoLists;
import com.example.todo_app.Repo.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private TodoRepo todoRepo;
    public TodoServiceImpl(TodoRepo todoRepo) {
        super();
        this.todoRepo = todoRepo;
    }
    @Override
    public TodoLists savedTodos(TodoLists todoLists) {
        return todoRepo.save(todoLists);
    }
    @Override
    public List<TodoLists> getAllTodos() {
        return todoRepo.findAll();
    }
}
