package com.app.contoller;

import com.app.model.Course;
import com.app.model.Student;
import com.app.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    private CoursesService coursesService;

    @PostMapping
    public void create(@RequestBody Course course) {
        coursesService.create(course);
    }

    @GetMapping("/user/{courseId}")
    public List<Student> findUsersForCourse(@PathVariable long courseId){
        return coursesService.findCoursesForUser(courseId);
    }

    @GetMapping("/{id}")
    public Course read(@PathVariable long id) {
        return coursesService.find(id).get();
    }

    @GetMapping
    public Iterable<Course> readAll() {
        return coursesService.findAll();
    }

    @PutMapping
    public void update(@RequestBody Course course) {
        coursesService.update(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        coursesService.delete(id);
    }

    @DeleteMapping
    public void deleteAll() {
        coursesService.deleteAll();
    }

    @GetMapping("/nostudents")
    public List<Course> findCoursesWithoutStudents(){
        return coursesService.coursesWithoutStudents();
    }

}
