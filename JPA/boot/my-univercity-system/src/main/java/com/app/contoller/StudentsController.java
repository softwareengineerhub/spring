package com.app.contoller;

import com.app.model.Course;
import com.app.model.Student;
import com.app.service.CoursesService;
import com.app.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;
    @Autowired
    private CoursesService coursesService;

    @PostMapping
    public void create(@RequestBody Student student) {
        studentsService.save(student);
    }

    @GetMapping("/courses/user/{userId}")
    public List<Course> findCoursesForUser(@PathVariable long userId) {
        return studentsService.findCoursesForUser(userId);
    }

    @GetMapping("/{id}")
    public Student read(@PathVariable long id) {
        return studentsService.find(id).get();
    }

    @GetMapping
    public List<Course> readAll() {
        return (List) studentsService.findAll();
    }

    @GetMapping("/nocourses")
    public List<Student> findStudentsWithoutCourses(){
        return studentsService.studentsWithoutCourses();
    }

    @PutMapping
    public void update(@RequestBody Student student) {
        studentsService.update(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        studentsService.delete(id);
    }

    @DeleteMapping
    public void deleteAll() {
        studentsService.deleteAll();
    }


    @PostMapping("/register/student/{studentId}/course/{courseId}")
    public void register(@PathVariable long studentId, @PathVariable long courseId) {
        studentsService.find(studentId).ifPresent(student -> {

            System.out.println("student is present");

            List<Course> courses = studentsService.findCoursesForUser(studentId);
            System.out.println("courses.size=" + courses.size());

            if (courses.size() < 5) {
                coursesService.find(courseId).ifPresent(course -> {
                    if (course.getStudents().size() <= 50) {
                        courses.add(course);
                        studentsService.update(student);
                        course.getStudents().add(student);
                        coursesService.update(course);
                    }
                });
            }
        });

    }

}
