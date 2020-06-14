package top.jionjion.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import top.jionjion.bean.Student;

/**
 * @author Jion
 */
@SpringBootTest
@Slf4j
class StudentMapperTest {

    @Autowired
    StudentMapper studentMapper;

    @Test
    void findByUserId(){
        Student student = studentMapper.findByUserId(1);
        Assert.notNull(student,"查询失败!");
        log.info("查询成功" + student.toString());
    }
}