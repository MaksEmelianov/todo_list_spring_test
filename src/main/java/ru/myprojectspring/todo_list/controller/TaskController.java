package ru.myprojectspring.todo_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.myprojectspring.todo_list.model.Task;
import ru.myprojectspring.todo_list.repository.TaskRepository;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PostMapping("/all")
    public List<Task> addAllTasks(@RequestBody List<Task> taskList) {
        return taskList.stream().map(this::addTask).toList();
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    @GetMapping("{id}")
    public Task getTaskById(@PathVariable Long id) {
        return findTaskById(id);
    }

    @PutMapping("{id}/done")
    public Task markAsDone(@PathVariable Long id) {
        Task task = findTaskById(id);
        if (!task.isDone()) {
            task.setDone(true);
        }
        return taskRepository.save(task);
    }

    @PatchMapping("{id}/done:mark-as-done")
    public void patchMethod(@PathVariable Long id){
        if (!findTaskById(id).isDone()) {
            taskRepository.markAsDone(id);
        }
    }

    @DeleteMapping("{id}")
    public void deleteTaskById(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    private Task findTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElseThrow();
    }
}
