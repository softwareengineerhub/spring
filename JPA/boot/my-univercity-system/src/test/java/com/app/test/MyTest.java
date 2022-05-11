package com.app.test;

import com.app.service.CoursesService;
import com.app.service.StudentsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
//@DataJpaTest
//@SpringBootTest
//@SpringBootTest(classes = {AppConfigTestAppConfig.class, CoursesService.class, StudentsService.class})
//@SpringBootTest(classes = {MainTest.class})
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.NONE)
public class MyTest {

    @Autowired
    private CoursesService coursesService;
    @Autowired
    private StudentsService studentsService;

    @Test
    public void test() {
       // coursesService.toString();
        //init();
        /*Student student = studentsService.find(1).get();
        assertTrue(student.getAge() == 1);
        assertTrue("Name1".equals(student.getName()));
        Course course = coursesService.find(1).get();
        assertTrue("Title1".equals(course.getTitle()));*/
    }

}
