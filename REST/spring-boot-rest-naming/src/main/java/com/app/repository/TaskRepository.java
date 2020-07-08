package com.app.repository;

import com.app.dto.TaskDto;
import com.app.dto.TaskProjection;
import com.app.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(value = "SELECT * from task WHERE user_id=:userId", nativeQuery = true)
    List<TaskProjection> findAllTasks(@Param("userId") int userId);

    @Query(value = "SELECT * from task", nativeQuery = true)
    List<TaskDto> findAllTasks();

    @Query(value = "SELECT t from Task t")
    List<TaskProjection> findAllTasksProjection();

    @Query(value = "SELECT t from Task t where t.id=:taskId")
    TaskProjection findTasksProjectionById(@Param("taskId") int taskId);

    @Query(value = "SELECT max(t.taskId) from Task t where t.site=(Select s.id From Site s where s.id=:siteId)")
    Integer findMaxTaskIdBySite(@Param("siteId") int siteId);


}
