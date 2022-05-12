package com.app.service;

import com.app.model.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursesServiceTest {

    @Autowired
    private CoursesService coursesService;
    @Autowired
    private DataSource dataSource;

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
