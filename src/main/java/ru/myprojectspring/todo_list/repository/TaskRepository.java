package ru.myprojectspring.todo_list.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.myprojectspring.todo_list.model.Task;

import java.util.List;

@Repository
@Transactional
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    void deleteById(Long Id);

    @Query("select t from Task t join User u on t.user_id = u.id where u.id = :uid")
    List<Task> findMyTasks(@Param("uid") Long uid);

    @Query("select t from Task t join User u on t.user_id = u.id where u.id = :uid and t.id = :tid")
    Task findMyTaskById(@Param("uid") Long uid, @Param("tid") Long tid);

    @Query("select t from Task t join User u on t.user_id = u.id where u.id = :uid and t.description = :tdesc")
    Task findMyTaskByDescription(@Param("uid") Long uid, @Param("tdesc") String desc);

    @Modifying
    @Query("update Task t set t.done = true where t.id = :id")
    void markAsDone(@Param("id") Long id);
}
