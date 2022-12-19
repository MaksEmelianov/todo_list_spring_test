package ru.myprojectspring.todo_list.service.task;

import ru.myprojectspring.todo_list.model.Task;
import ru.myprojectspring.todo_list.model.User;

import java.util.List;

public interface TaskService {

    Task create(Task task);

    List<Task> findMyTasks(User user);

    Task findMyTaskById(User user, Long tid);

    Task findMyTaskByDesc(User user, String desc);

    void markAsDone(Long tid);

    void deleteById(Long tid);
}
