package top.jionjion.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import top.jionjion.bean.Student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Jion
 */
@SpringBootTest
@Slf4j
class StudentQueryMapperTest {

    @Autowired
    StudentQueryMapper mapper;

    @Test
    void findStudentById(){
        Student student = mapper.findStudentById(1);
        Assert.notNull(student,"失败!");
        log.info("查询成功" + student.toString());
    }

    @Test
    void findStudentByName(){
        List<Student> studentList = mapper.findStudentByName("Jion");
        Assert.notNull(studentList, "失败!");
        log.info("查询成功" + studentList.toString());
    }

    @Test
    void findByLikeStudentName(){
        List<Student> studentList = mapper.findStudentByLikeName("J");
        Assert.notNull(studentList, "失败!");
        log.info("查询成功" + studentList.toString());
    }

    @Test
    void findStudentByBirthdayDate(){
        List<Student> studentList = mapper.findStudentByBirthdayDate(LocalDate.of(1994, 4, 12));
        Assert.notNull(studentList, "失败!");
        log.info("查询成功" + studentList.toString());
    }

    @Test
    void findStudentByBirthdayStr(){
        List<Student> studentList = mapper.findStudentByBirthdayStr("1994-04-12");
        Assert.notNull(studentList, "失败!");
        log.info("查询成功" + studentList.toString());
    }

    @Test
    void findStudentByBirthdayBetween(){
        List<Student> studentList = mapper.findStudentByBirthdayBetween("1990-01-01", "2000-01-01");
        Assert.notNull(studentList, "失败!");
        log.info("查询成功" + studentList.toString());
    }

    @Test
    void findStudentByIdBetween(){
        List<Student> studentList = mapper.findStudentByIdBetween(1, 10);
        Assert.notNull(studentList, "失败!");
        log.info("查询成功" + studentList.toString());
    }

    @Test
    void findCount(){
        Long count = mapper.findCount();
        Assert.notNull(count, "失败!");
        log.info("查询成功" + count.toString());
    }

    @Test
    void findRow(){
        List<Map> map = mapper.findRow();
        Assert.notNull(map, "失败!");
        log.info("查询成功" + map.toString());
    }

    @Test
    void findStudentByIdIn(){
        List<Student> studentList = mapper.findStudentByIdIn(Arrays.asList(1, 2, 3));
        Assert.notNull(studentList, "失败!");
        log.info("查询成功" + studentList.toString());
    }

    @Test
    void findStudentByIdLt(){
        List<Student> studentList = mapper.findStudentByIdLt(5);
        Assert.notNull(studentList, "失败!");
        log.info("查询成功" + studentList.toString());
    }

    @Test
    void findStudentByAgeNull(){
        List<Student> studentList = mapper.findStudentByAgeNull();
        Assert.notNull(studentList, "失败!");
        log.info("查询成功" + studentList.toString());
    }

    @Test
    void findAllOrderByIdDesc(){
        List<Student> studentList = mapper.findAllOrderByIdDesc();
        Assert.notNull(studentList, "失败!");
        log.info("查询成功" + studentList.toString());
    }

    @Test
    void findAllLimit(){
        List<Student> studentList = mapper.findAllLimit(0, 5);
        Assert.notNull(studentList, "失败!");
        log.info("查询成功" + studentList.toString());
    }
}