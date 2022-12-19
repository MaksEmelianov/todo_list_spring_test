package ru.myprojectspring.todo_list.service.user;

import ru.myprojectspring.todo_list.model.User;

public interface UserService {

    User createUser(User user);

    User getCurrentUser();
}
