package top.jionjion.mybatis.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.mybatis.dto.Teacher;
import top.jionjion.mybatis.service.ITeacherService;

/**
 * 测试封装的Service类的接口
 *
 * @author Jion
 */
@Slf4j
@SpringBootTest
class TeacherServiceImplTest {

    @Autowired
    ITeacherService teacherService;

    @Test
    public void test() {
        Teacher teacher = teacherService.getById(1);
        log.info("执行查询, {}", teacher);
    }
}