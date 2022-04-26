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
            throw new ResourceNotFound("Todo Not Found","id", id);
        }
    }

    @Override
    public TodoLists savedTodos(TodoLists todoLists) {
        return todoRepo.save(todoLists);
    }

    @Override
    public TodoLists updateTodos(TodoLists todoLists, long id) {
        TodoLists existingTodoLists = todoRepo.findById(id).orElseThrow(()
                -> new ResourceNotFound("Todo Not Found","id", id));
        existingTodoLists.setListName(todoLists.getlistBody());
        todoRepo.save(existingTodoLists);
        return existingTodoLists;
    }

    @Override
    public void deleteTodos(long id) {
        todoRepo.findById(id).orElseThrow(()
                -> new ResourceNotFound("This Todo does not exist","id", id));
        todoRepo.deleteById(id);
    }
}
