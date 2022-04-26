package com.example.todo_app.Controller;
import com.example.todo_app.Models.TodoLists;
import com.example.todo_app.Service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/lists")
public class TodoController {
    private TodoService todoService;
    public TodoController( TodoService todoService ) {
        super();
        this.todoService = todoService;
    }
    @GetMapping ("{id}")
    @CrossOrigin
    public ResponseEntity<TodoLists> getTodoById(@PathVariable("id") long todoid){
        return new ResponseEntity<TodoLists>(todoService.getTodoById(todoid),HttpStatus.OK);
    }
    @GetMapping
    @CrossOrigin
    public List<TodoLists> getAllTodos(){
     return todoService.getAllTodos();
    }
    @PostMapping
    @CrossOrigin
    public ResponseEntity<TodoLists> saveTodoLists(@RequestBody TodoLists todoLists){
        return new ResponseEntity<TodoLists>(todoService.savedTodos(todoLists), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    @CrossOrigin
    public ResponseEntity<TodoLists> updateTodos(@PathVariable("id") long id, @RequestBody TodoLists todoLists){
        return new ResponseEntity<TodoLists>(todoService.updateTodos(todoLists, id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    @CrossOrigin
    public ResponseEntity<String> deleteTodos(@PathVariable("id") long id) {todoService.deleteTodos(id);
        return new ResponseEntity<String>("Todo list has been deleted", HttpStatus.OK);
    }
}
