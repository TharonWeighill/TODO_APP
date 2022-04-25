package com.example.todo_app.Service;
import com.example.todo_app.Models.TodoLists;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface TodoService {
    TodoLists savedTodos(TodoLists todoLists);
    List<TodoLists> getAllTodos();
}
