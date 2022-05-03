package com.example.todo_app.Service;
import com.example.todo_app.Models.Users;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    Users getUserById(Long id);
}
