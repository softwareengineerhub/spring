package com.app.repository;

import com.app.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursesRepository extends CrudRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.students is empty")
    public List<Course> coursesWithoutStudents();

}
