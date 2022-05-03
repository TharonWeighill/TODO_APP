package com.example.todo_app.Service;
import com.example.todo_app.Models.TodoLists;
import com.example.todo_app.Models.Users;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    Users getUserById(Long id);
    Users savedUsers(Users users);
    Users updateUsers(Users users, long id);
    void deleteUsers(long id);
}
