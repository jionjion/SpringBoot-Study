package top.jionjion.jdbc.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.jdbc.bean.Student;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Jion
 */
@Slf4j
@SpringBootTest
class StudentTemplateTest{

    @Autowired
    StudentTemplate studentTemplate;

    @Test
    void queryStudentList() {
        List<Student> students = studentTemplate.queryStudentList();
        log.info("查询>>>" + students.toString());
    }

    @Test
    void saveStudent() {
        studentTemplate.saveStudent(new Student(0,"Jion",10,"上海", LocalDate.of(1994,11,1)));
    }
}