package top.jionjion.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.mybatis.dto.Teacher;

import java.util.*;

/**
 * 测试使用 Mybatis-plus 进行Curd操作
 *
 * @author Jion
 */
@Slf4j
@SpringBootTest
class TeacherCurdMapperTest {

    @Autowired
    TeacherCurdMapper teacherCurdMapper;

    /**
     * 插入一条记录
     */
    @Test
    void insert() {
        Teacher teacher = new Teacher();
        teacher.setId(-1);
        teacher.setName("Jetty");
        teacher.setAge(18);
        teacher.setWorkday(new Date());
        teacher.setAddress("ShangHai");
        int insert = teacherCurdMapper.insert(teacher);
        log.info("执行结果, {}", insert);
    }


    /**
     * 根据 ID 删除
     */
    @Test
    void deleteById() {
        int delete = teacherCurdMapper.deleteById(-1);
        log.info("执行删除结果, {}", delete);
    }

    /**
     * 根据 columnMap 条件，删除记录
     * 仅作为简单的等值查询
     */
    @Test
    void deleteByMap() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", "Jion");
        int delete = teacherCurdMapper.deleteByMap(columnMap);
        log.info("执行删除结果, {}", delete);
    }

    /**
     * 根据 entity 条件，删除记录
     */
    @Test
    void delete() {
        Wrapper<Teacher> queryWrapper = new QueryWrapper<>();
        int delete = teacherCurdMapper.delete(queryWrapper);
        log.info("执行删除结果, {}", delete);
    }

    /**
     * 删除（根据ID 批量删除）
     */
    @Test
    void deleteBatchIds() {
        Collection<Integer> idList = Collections.singletonList(3);
        int delete = teacherCurdMapper.deleteBatchIds(idList);
        log.info("执行删除结果, {}", delete);
    }

    /**
     * 根据 ID 修改
     */
    @Test
    void updateById() {
        Teacher teacher = teacherCurdMapper.selectById(1);
        teacher.setAge(teacher.getAge() + 1);
        int update = teacherCurdMapper.updateById(teacher);
        log.info("执行更新结果, {}", update);
    }

    /**
     * 根据 whereEntity 条件，更新记录
     */
    @Test
    void update() {
        Teacher teacher = teacherCurdMapper.selectById(1);
        Wrapper<Teacher> updateWrapper = new QueryWrapper<>();
        int update = teacherCurdMapper.update(teacher, updateWrapper);
        log.info("执行更新结果, {}", update);
    }

    /**
     * 根据 ID 查询
     */
    @Test
    void selectById() {
        Teacher teacher = teacherCurdMapper.selectById(3);
        log.info("执行查询结果, {}", teacher);
    }

    /**
     * 查询（根据ID 批量查询）
     */
    @Test
    void selectBatchIds() {
        Collection<Integer> idList = Collections.singletonList(1);
        List<Teacher> teachers = teacherCurdMapper.selectBatchIds(idList);
        log.info("执行查询结果, {}", teachers);
    }

    /**
     * 查询（根据 columnMap 条件）
     * 仅作为简单的等值查询
     */
    @Test
    void selectByMap() {
        Map<String, Object> columnMap = new HashMap<>();
        // 会拼接为 where name = 'Jetty' and age = 20
        columnMap.put("name", "Jetty");
        columnMap.put("age", 20);
        List<Teacher> teachers = teacherCurdMapper.selectByMap(columnMap);
        log.info("执行查询结果, {}", teachers);
    }

    /**
     * 根据 entity 条件，查询一条记录
     */
    @Test
    void selectOne() {
        Wrapper<Teacher> queryWrapper = new QueryWrapper<>();
        Teacher teacher = teacherCurdMapper.selectOne(queryWrapper);
        log.info("执行查询结果, {}", teacher);
    }

    /**
     * 根据 Wrapper 条件，查询总记录数
     */
    @Test
    void selectCount() {
        Wrapper<Teacher> queryWrapper = new QueryWrapper<>();
        Long count = teacherCurdMapper.selectCount(queryWrapper);
        log.info("执行查询结果, {}", count);
    }

    /**
     * 根据 entity 条件，查询全部记录
     */
    @Test
    void selectList() {
        Wrapper<Teacher> queryWrapper = new QueryWrapper<>();
        List<Teacher> teachers = teacherCurdMapper.selectList(queryWrapper);
        log.info("执行查询结果, {}", teachers);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     */
    @Test
    void selectMaps() {
        Wrapper<Teacher> queryWrapper = new QueryWrapper<>();
        List<Map<String, Object>> result = teacherCurdMapper.selectMaps(queryWrapper);
        log.info("执行查询结果, {}", result);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     * 注意： 只返回第一个字段的值
     */
    @Test
    void selectObjs() {
        Wrapper<Teacher> queryWrapper = new QueryWrapper<>();
        List<Object> result = teacherCurdMapper.selectObjs(queryWrapper);
        log.info("执行查询结果, {}", result);
    }

    /**
     * 根据 entity 条件，查询全部记录（并翻页）
     */
    @Test
    void selectPage() {
        // 分页, 当前页 ; 每页显示条数，默认 10 ; 总数 ; 是否进行 count 查询
        IPage<Teacher> page = new Page<>(1, 3, 5, true);
        Wrapper<Teacher> queryWrapper = new QueryWrapper<>();
        IPage<Teacher> result = teacherCurdMapper.selectPage(page, queryWrapper);
        log.info("执行查询结果, {}", result.getRecords());
    }

    /**
     * 根据 Wrapper 条件，查询全部记录（并翻页）
     */
    @Test
    void selectMapsPage() {
        // 分页, 当前页 ; 每页显示条数，默认 10 ; 总数 ; 是否进行 count 查询
        IPage<Map<String, Object>> page = new Page<>(1, 5, 100, true);
        Wrapper<Teacher> queryWrapper = new QueryWrapper<>();
        IPage<Map<String, Object>> result = teacherCurdMapper.selectMapsPage(page, queryWrapper);
        log.info("执行查询结果, {}", result);
    }
}