package com.example.todo_app.Controller;
import com.example.todo_app.Models.TodoLists;
import com.example.todo_app.Repo.TodoRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public String saveList(@RequestBody TodoLists todoLists) {
        todoRepo.save(todoLists);
    return "Todo list has been saved!";
    }
    @PutMapping(value ="update/{id}")
    public String updateTodoList(@PathVariable long id, @RequestBody TodoLists todoLists){
        TodoLists updateTodoList = todoRepo.findById(id).get();
        updateTodoList.setListName(todoLists.getListName());
        updateTodoList.setlistBody(todoLists.getlistBody());
        todoRepo.save(updateTodoList);
        return "Your List has been updated";
    }
    @DeleteMapping(value = "/delete/{id}")
        public String deleteTodoList(@PathVariable long id) {
        TodoLists deleteTodoList = todoRepo.findById(id).get();
        todoRepo.delete(deleteTodoList);
        return "Your list has been deleted";
    }
}

