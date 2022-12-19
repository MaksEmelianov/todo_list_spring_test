package ru.myprojectspring.todo_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.myprojectspring.todo_list.model.Task;
import ru.myprojectspring.todo_list.model.User;
import ru.myprojectspring.todo_list.service.task.TaskServiceImpl;
import ru.myprojectspring.todo_list.service.user.UserDetailsServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @GetMapping
    public List<Task> findMyTasks(@AuthenticationPrincipal User user) {
        return taskService.findMyTasks(user);
    }

    @GetMapping("id/{tid}")
    public Task findMyTaskById(@AuthenticationPrincipal User user,
                               @PathVariable Long tid) {
        return taskService.findMyTaskById(user, tid);
    }

    @GetMapping("desc/{desc}")
    public Task findMyTaskByDesc(@AuthenticationPrincipal User user,
                                 @PathVariable String desc) {
        return taskService.findMyTaskByDesc(user, desc);
    }

    @GetMapping("{tid}/done")
    public void markAsDone(@PathVariable Long tid) {
        taskService.markAsDone(tid);
    }

    @DeleteMapping("{tid}/delete")
    public void deleteById(@PathVariable Long tid) {
        taskService.deleteById(tid);
    }
}
