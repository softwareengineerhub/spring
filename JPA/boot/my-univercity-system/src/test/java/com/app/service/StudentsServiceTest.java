package com.app.service;

import com.app.model.Student;
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
public class StudentsServiceTest {

    @Autowired
    private StudentsService studentsService;
    @Autowired
    private DataSource dataSource;

    @Test
    public void crudTest() {
        List<Student> students = (List<Student>) studentsService.findAll();
        assertTrue(students.size() == 0);
        Student student = new Student();
        student.setName("Name1");
        student.setAge(1);
        studentsService.save(student);
        students = (List<Student>) studentsService.findAll();
        assertTrue(students.size() == 1);
        student = new Student();
        student.setName("Name2");
        student.setAge(2);
        studentsService.save(student);
        students = (List<Student>) studentsService.findAll();
        assertTrue(students.size() == 2);
    }

}
