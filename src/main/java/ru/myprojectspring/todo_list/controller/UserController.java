package ru.myprojectspring.todo_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.myprojectspring.todo_list.model.User;
import ru.myprojectspring.todo_list.service.user.UserServiceImpl;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/users/me")
    public User currentUser() {
        return userService.getCurrentUser();
    }
}
