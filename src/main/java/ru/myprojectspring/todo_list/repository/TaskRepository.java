package ru.myprojectspring.todo_list.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.myprojectspring.todo_list.model.Task;

@Repository
@Transactional
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    @Modifying
    @Query("update Task t set t.done = true where t.id = :id")
    void markAsDone(@Param("id") Long id);
}
