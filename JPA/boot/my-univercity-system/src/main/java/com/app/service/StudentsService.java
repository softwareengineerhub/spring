package com.app.service;

import com.app.model.Course;
import com.app.model.Student;
import com.app.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    public void save(Student student) {
        studentsRepository.save(student);
    }

    public Optional<Student> find(long id) {
        return studentsRepository.findById(id);
    }

    public Iterable<Student> findAll() {
        return studentsRepository.findAll();
    }

    public void update(Student student) {
        studentsRepository.save(student);
    }

    public void delete(long id) {
        studentsRepository.deleteById(id);
    }

    public void deleteAll() {
        studentsRepository.deleteAll();
    }

    public List<Course> findCoursesForUser(long userId){
        Student student = studentsRepository.findById(userId).get();
        return student.getCourses();
    }

    public List<Student> studentsWithoutCourses() {
        return studentsRepository.studentsWithoutCourses();
    }

}
