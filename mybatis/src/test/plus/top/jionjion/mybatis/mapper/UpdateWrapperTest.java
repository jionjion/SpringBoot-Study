package top.jionjion.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.mybatis.dto.Teacher;

/**
 * 测试 UpdateWrapper 类的使用.
 * <p>
 * 官网  <a href="https://mybatis.plus/guide/wrapper.html">...</a>
 *
 * @author Jion
 */
@Slf4j
@SpringBootTest
class UpdateWrapperTest {

    @Autowired
    TeacherCurdMapper teacherCurdMapper;

    /**
     * 修改.触发内部有版本 version 拦截器, modify_date日期版本拦截器
     * UPDATE teacher SET name=?, age=?, version=?, modify_date=?, name=?,address=? WHERE deleted=0 AND (id = ? AND version = ?)
     */
    @Test
    void set() {
        Teacher teacher = teacherCurdMapper.selectById(4);
        UpdateWrapper<Teacher> wrapper = new UpdateWrapper<>();
        wrapper.set("name", "jion");
        wrapper.set("address", null);
        wrapper.eq("id", 4);
        int result = teacherCurdMapper.update(teacher, wrapper);
        log.info("更新结果, {}", result);
    }

    /**
     * 修改,触发内部有版本 version 拦截器,  modify_date日期版本拦截器
     * UPDATE teacher SET name=?, age=?, version=?, modify_date=?, name = 'jion',address = null WHERE deleted=0 AND (id = ? AND version = ?)
     */
    @Test
    void setSql() {
        Teacher teacher = teacherCurdMapper.selectById(4);
        UpdateWrapper<Teacher> wrapper = new UpdateWrapper<>();
        wrapper.setSql("name = 'jion'");
        wrapper.setSql("address = null");
        wrapper.eq("id", 4);
        int result = teacherCurdMapper.update(teacher, wrapper);
        System.out.println(result);
    }
}
