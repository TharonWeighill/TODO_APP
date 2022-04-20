package com.example.todo_app.Controller;
import com.example.todo_app.Models.TodoLists;
import com.example.todo_app.Repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private TodoRepo todoRepo;
    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }
    @GetMapping(value = "/lists")
    public List<TodoLists> getLists() {
        return todoRepo.findAll();
    }
    @PostMapping(value = "/save")
    public String saveList(TodoLists todoLists) {
    todoRepo.save(todoLists);
    return "Todo list has been saved!";
    }
}
