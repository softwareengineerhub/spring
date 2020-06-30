package com.repository;

import com.model.MaintananceTask;
import com.model.MaintananceTaskDto;
import com.model.MaintananceTaskProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaintananceRepository extends JpaRepository<MaintananceTask, Integer> {

    @Query("SELECT m FROM MaintananceTask m WHERE LOWER(m.site) = LOWER(:site)")
    Page<MaintananceTaskProjection> filterBySite(@Param("site") String site, Pageable pageable);

    @Query("SELECT m FROM MaintananceTask m WHERE m.priority = :priority")
    Page<MaintananceTaskProjection> filterByPriority(@Param("priority") int priority, Pageable pageable);

    @Query("SELECT m FROM MaintananceTask m WHERE LOWER(m.device) = LOWER(:device)")
    Page<MaintananceTaskProjection> filterByDevice(@Param("device") String device, Pageable pageable);

    @Query("SELECT m FROM MaintananceTask m WHERE (LOWER(m.device) = LOWER(:device) AND m.priority = :priority)")
    Page<MaintananceTaskProjection> filterByDeviceAndPriority(@Param("device") String device, @Param("priority") int priority, Pageable pageable);

    @Query("SELECT m FROM MaintananceTask m WHERE (LOWER(m.site) = LOWER(:site) AND m.priority = :priority)")
    Page<MaintananceTaskProjection> filterBySiteAndPriority(@Param("site") String site, @Param("priority") int priority, Pageable pageable);

    @Query("SELECT m FROM MaintananceTask m WHERE (LOWER(m.site) = LOWER(:site) AND m.device = :device)")
    Page<MaintananceTaskProjection> filterBySiteAndDevice(@Param("site") String site, @Param("device") String device, Pageable pageable);

    @Query("SELECT m FROM MaintananceTask m WHERE (LOWER(m.site) = LOWER(:site) AND m.priority = :priority AND LOWER(m.device) = LOWER(:device))")
    Page<MaintananceTaskProjection> filter(@Param("site") String site, @Param("device") String device, @Param("priority") int priority, Pageable pageable);

    @Modifying
    @Query("DELETE FROM MaintananceTask m WHERE m.id = :id")
    void deleteById(@Param("id") long id);

    @Query(value = "SELECT * FROM maintanance_task WHERE ID=:id", nativeQuery = true)
    MaintananceTaskProjection findDataById(@Param("id") long id);

    //@Query("SELECT max(m.taskid) FROM MaintananceTask m")
    //Integer findMaxByTakId();

    @Query(value = "SELECT max(taskid) FROM maintanance_task", nativeQuery = true)
    Integer findMaxByTakId();

    @Query(value = "SELECT m FROM MaintananceTask m")
    Page<MaintananceTaskProjection> findAllContent(Pageable pageable);

    //@Modifying
    //@Query("DELETE FROM MaintananceTask m WHERE m.id = :id")
    //void updateById(@Param("id") long id)

    //@Query(value = "SELECT * FROM maintanance_task where priority = :priority", nativeQuery = true)
    //Page<MaintananceTaskProjection> findAllContent(@Param("priority") int priority, Pageable pageable);

    //@Query(value = "SELECT * FROM maintanance_task where priority = :priority", nativeQuery = true)
    //Page<MaintananceTaskProjection> findAllContent2(@Param("priority") int priority, Pageable pageable);

    //@Query(value = "SELECT * FROM maintanance_task", nativeQuery = true)
   // List<MaintananceTaskDto> filterTest();

    @Query(value = "SELECT maintanance_task.*, max(id) as max FROM maintanance_task", nativeQuery = true)
    List<MaintananceTaskProjection> filterTest();

}
