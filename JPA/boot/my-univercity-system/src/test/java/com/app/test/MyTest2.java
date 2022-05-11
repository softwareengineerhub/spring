package com.app.test;

import com.app.repository.CoursesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
public class MyTest2 {

    @Autowired
    private CoursesRepository coursesRepository;

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
