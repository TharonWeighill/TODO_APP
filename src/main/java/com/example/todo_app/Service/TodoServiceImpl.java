package com.example.todo_app.Service;

import com.example.todo_app.Exception.ResourceNotFound;
import com.example.todo_app.Models.TodoLists;
import com.example.todo_app.Repo.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    private TodoRepo todoRepo;
    public TodoServiceImpl(TodoRepo todoRepo) {
        super();
        this.todoRepo = todoRepo;
    }
    @Override
    public List<TodoLists> getAllTodos() {
        return todoRepo.findAll();
    }
    @Override
    public TodoLists getTodoById(Long id) {
        Optional<TodoLists> todoLists = todoRepo.findById(id);
        if(todoLists.isPresent()) {
            return todoLists.get();
        }else {
            throw new ResourceNotFound("Todo Not Found", id);
        }
    }

    @Override
    public TodoLists savedTodos(TodoLists todoLists) {
        return todoRepo.save(todoLists);
    }
}
