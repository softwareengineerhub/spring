package com.app.test;

import com.app.model.Course;
import com.app.service.CoursesService;
import com.app.service.StudentsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class MyTest3 {

    @Autowired
    private CoursesService coursesService;
    @Autowired
    private StudentsService studentsService;

    @Test
    public void crudTest() {
        List<Course> courses = (List<Course>) coursesService.findAll();
        assertTrue(courses.size() == 0);
        Course course = new Course();
        course.setTitle("C1");
        coursesService.create(course);
        courses = (List<Course>) coursesService.findAll();
        assertTrue(courses.size() == 1);
        course = new Course();
        course.setTitle("C2");
        coursesService.create(course);
        courses = (List<Course>) coursesService.findAll();
        assertTrue(courses.size() == 2);
    }

}
