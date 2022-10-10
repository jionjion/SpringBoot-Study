package top.jionjion.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.mybatis.dto.Teacher;

import java.util.List;

/**
 * 测试使用 Mybatis-plus 进行Curd操作
 *
 * @author Jion
 */
@Slf4j
@SpringBootTest
class TeacherCustomMapperTest {

    @Autowired
    TeacherCurdMapper teacherCurdMapper;

    /**
     * 通过注解自定义SQL
     */
    @Test
    void findListByAnnotation() {
        // select * from teacher WHERE (id = ?)
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1);
        List<Teacher> result = teacherCurdMapper.findListByAnnotation(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 通过配置文件自定义SQL
     */
    @Test
    void findListByXml() {
        // select * from teacher WHERE (id = ?)
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1);
        List<Teacher> result = teacherCurdMapper.findListByXml(wrapper);
        log.info("查询结果, {}", result);
    }
}