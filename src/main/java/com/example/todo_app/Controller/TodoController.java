package com.example.todo_app.Controller;
import com.example.todo_app.Models.TodoLists;
import com.example.todo_app.Service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lists")
public class TodoController {
    private TodoService todoService;
    public TodoController( TodoService todoService ) {
        super();
        this.todoService = todoService;
    }
    @PostMapping
    public ResponseEntity<TodoLists> saveTodoLists(@RequestBody TodoLists todoLists){
        return new ResponseEntity<TodoLists>(todoService.savedTodos(todoLists), HttpStatus.CREATED);
    }
}
