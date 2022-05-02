package com.example.todo_app.Controller;
import com.example.todo_app.Models.TodoLists;
import com.example.todo_app.Service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/oauth-redirect")
public class FusionAuthController {
    private TodoService todoService;

    public FusionAuthController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @GetMapping()
    @CrossOrigin
    public ResponseEntity<TodoLists> getTodoById(@PathVariable("id") long todoid) {
        System.out.println();
        return new ResponseEntity<TodoLists>(todoService.getTodoById(todoid), HttpStatus.OK);
    }
}