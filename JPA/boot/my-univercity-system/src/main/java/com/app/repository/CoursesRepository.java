package com.app.repository;

import com.app.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends CrudRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.students is empty")
    public List<Course> coursesWithoutStudents();

}
