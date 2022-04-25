package com.example.todo_app.Service;
import com.example.todo_app.Models.TodoLists;
import org.springframework.stereotype.Service;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public interface TodoService {
    List<TodoLists> getAllTodos();
    TodoLists getTodoById(Long id);
    TodoLists savedTodos(TodoLists todoLists);
    TodoLists updateTodos(TodoLists todoLists, long id);
}
