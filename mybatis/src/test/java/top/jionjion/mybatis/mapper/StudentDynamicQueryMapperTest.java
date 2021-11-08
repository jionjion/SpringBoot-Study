package top.jionjion.mybatis.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import top.jionjion.mybatis.dto.Student;
import top.jionjion.mybatis.mapper.StudentDynamicQueryMapper;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jion
 */
@Slf4j
@SpringBootTest
class StudentDynamicQueryMapperTest {

    @Autowired
    StudentDynamicQueryMapper mapper;


    @Test
    void findStudentById(){
        List<Student> students = mapper.findStudentByIf(1);
        Assert.notNull(students,"失败!");
        log.info("查询成功" + students);
    }

    @Test
    void findStudentByExampleChoose(){
        Student student = new Student();
        student.setAge(1);
        student.setName("i");
        List<Student> students = mapper.findStudentByExampleChoose(student);
        Assert.notNull(students,"失败!");
        log.info("查询成功" + students);
    }

    @Test
    void findStudentByExampleWhere(){
        Student student = new Student();
        student.setAge(1);
        student.setName("i");
        List<Student> students = mapper.findStudentByExampleWhere(student);
        Assert.notNull(students,"失败!");
        log.info("查询成功" + students);
    }

    @Test
    void findStudentByForeach(){
        List<Integer> ids = new LinkedList<>();
        ids.add(1);
        ids.add(2);
        List<Student> students = mapper.findStudentByForeach(ids);
        Assert.notNull(students,"失败!");
        log.info("查询成功" + students);
    }

}