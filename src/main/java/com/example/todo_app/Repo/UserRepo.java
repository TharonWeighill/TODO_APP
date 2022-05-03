package com.example.todo_app.Repo;
import com.example.todo_app.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
}
