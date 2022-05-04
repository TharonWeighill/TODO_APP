package com.example.todo_app.Controller;
import com.example.todo_app.Models.TodoLists;
import com.example.todo_app.Service.TodoService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping ("/oauth-redirect")
public class FusionAuthController {

    public FusionAuthController() {

        //1) \query param
        //2) \GET auth code
        //3) exchange auth code for access token
        //4) store token in cookie or as state
        //5) log out destroys state/cookie
        //6) redirect home
        //7) conditionally render nav bar to user logged in
        //8) connect cleanspeak to post todos

    }

    @GetMapping()
    @CrossOrigin
    public ResponseEntity<Void> getAuthCode(@RequestParam("code") String authCode) {
        System.out.println(authCode);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}