package com.example.todo_app.Service;
import com.example.todo_app.Models.TodoLists;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface TodoService {
    List<TodoLists> getAllTodos();
    TodoLists getTodoById(Long id);
    TodoLists savedTodos(TodoLists todoLists);
    TodoLists updateTodos(TodoLists todoLists, long id);
    TodoLists findUserById();
    void deleteTodos(long id);
}
