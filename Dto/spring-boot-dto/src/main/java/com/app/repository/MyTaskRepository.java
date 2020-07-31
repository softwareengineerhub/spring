package com.app.repository;

import com.app.model.MyTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.sql.Timestamp;

public interface MyTaskRepository extends JpaRepository<MyTask, Integer> {

    //@Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
   // @Query("UPDATE MyTask mt SET mt.lastrun=:lastrun where mt.id=:id")
    //@Modifying
    //void updateRunningTime(@Param("lastrun") Timestamp lastrun, @Param("id") int id);

    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    @Query("SELECT mt from MyTask mt where mt.id=:id")
    MyTask findTask(@Param("id") int id);

}
