package com.example.todo_app.Service;

import com.example.todo_app.Models.Users;
import com.example.todo_app.Repo.TodoRepo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private TodoRepo todoRepo;
    @Override
    public Users getUserById(Long id) {
        return null;
    }

    @Override
    public Users savedUsers(Users users) {
        return null;
    }

    @Override
    public Users updateUsers(Users users, long id) {
        return null;
    }

    @Override
    public void deleteUsers(long id) {

    }
}