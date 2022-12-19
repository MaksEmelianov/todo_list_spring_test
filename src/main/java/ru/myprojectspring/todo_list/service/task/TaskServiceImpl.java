package ru.myprojectspring.todo_list.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myprojectspring.todo_list.model.Task;
import ru.myprojectspring.todo_list.model.User;
import ru.myprojectspring.todo_list.repository.TaskRepository;

import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findMyTasks(User user) {
        return taskRepository.findMyTasks(user.getId());
    }

    @Override
    public Task findMyTaskById(User user, Long tid) {
        return taskRepository.findMyTaskById(user.getId(), tid);
    }

    @Override
    public Task findMyTaskByDesc(User user, String desc) {
        return taskRepository.findMyTaskByDescription(user.getId(), desc);
    }

    @Override
    public void markAsDone(Long id) {
        taskRepository.markAsDone(id);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
