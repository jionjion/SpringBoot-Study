package top.jionjion.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.dto.Teacher;

/**
 * @author Jion
 */
@Slf4j
@SpringBootTest
class TeacherCurdMapperTest {

    @Autowired
    TeacherCurdMapper teacherCurdMapper;

    @Test
    public void test(){
        Teacher teacher = teacherCurdMapper.selectById(1);
        log.info(teacher.toString());
    }
}