package com.app.repository;

import com.app.model.Course;
import com.app.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.courses is empty")
    public List<Student> studentsWithoutCourses();

}
