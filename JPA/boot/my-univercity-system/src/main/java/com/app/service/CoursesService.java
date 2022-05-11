package com.app.service;

import com.app.model.Course;
import com.app.model.Student;
import com.app.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;

    public void create(Course course) {
        coursesRepository.save(course);
    }

    public Optional<Course> find(long id) {
        return coursesRepository.findById(id);
    }

    public Iterable<Course> findAll() {
        return coursesRepository.findAll();
    }

    public void update(Course course) {
        coursesRepository.save(course);
    }

    public void delete(long id) {
        coursesRepository.deleteById(id);
    }

    public void deleteAll() {
        coursesRepository.deleteAll();
    }

    public List<Student> findCoursesForUser(long courseId) {
        Course course = coursesRepository.findById(courseId).get();
        return course.getStudents();
    }

    public List<Course> coursesWithoutStudents() {
        return coursesRepository.coursesWithoutStudents();
    }

}
