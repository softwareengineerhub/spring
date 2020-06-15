package com.repository;

import com.model.MaintananceTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MaintananceRepository extends JpaRepository<MaintananceTask, Integer> {

    @Query("SELECT m FROM MaintananceTask m WHERE LOWER(m.site) = LOWER(:site)")
    Page<MaintananceTask> filterBySite(@Param("site") String site, Pageable pageable);

    @Query("SELECT m FROM MaintananceTask m WHERE m.priority = :priority")
    Page<MaintananceTask> filterByPriority(@Param("priority") int priority, Pageable pageable);

    @Query("SELECT m FROM MaintananceTask m WHERE LOWER(m.device) = LOWER(:device)")
    Page<MaintananceTask> filterByDevice(@Param("device") String device, Pageable pageable);

    @Query("SELECT m FROM MaintananceTask m WHERE (LOWER(m.device) = LOWER(:device) AND m.priority = :priority)")
    Page<MaintananceTask> filterByDeviceAndPriority(@Param("device") String device, @Param("priority") int priority, Pageable pageable);

    @Query("SELECT m FROM MaintananceTask m WHERE (LOWER(m.site) = LOWER(:site) AND m.priority = :priority)")
    Page<MaintananceTask> filterBySiteAndPriority(@Param("site") String site, @Param("priority") int priority, Pageable pageable);

    @Query("SELECT m FROM MaintananceTask m WHERE (LOWER(m.site) = LOWER(:site) AND m.device = :device)")
    Page<MaintananceTask> filterBySiteAndDevice(@Param("site") String site, @Param("device") String device, Pageable pageable);

    @Query("SELECT m FROM MaintananceTask m WHERE (LOWER(m.site) = LOWER(:site) AND m.priority = :priority AND LOWER(m.device) = LOWER(:device))")
    Page<MaintananceTask> filter(@Param("site") String site, @Param("device") String device, @Param("priority") int priority, Pageable pageable);

    @Modifying
    @Query("DELETE FROM MaintananceTask m WHERE m.id = :id")
    void deleteById(@Param("id") long id);

    //@Modifying
    //@Query("DELETE FROM MaintananceTask m WHERE m.id = :id")
    //void updateById(@Param("id") long id)

}
