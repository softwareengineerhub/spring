package com.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {

    @Modifying
    @Query(value = "insert into test(device, task_id) values(:device, :taskid)", nativeQuery = true)
    public void creat(@Param("device")String device, @Param("taskid") int taskid);

    @Modifying
    @Query(value = "insert into test(device, task_id, value) values(:device, :taskid, :taskid)", nativeQuery = true)
    public void creat2(@Param("device")String device, @Param("taskid") int taskid);

    @Query(value = "SELECT * FROM spring_jpa_data3.test", nativeQuery = true)
    public List<TestProjection> findAllData();

}
