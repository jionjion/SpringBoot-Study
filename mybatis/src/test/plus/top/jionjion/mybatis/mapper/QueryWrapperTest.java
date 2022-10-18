package top.jionjion.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.mybatis.dto.Teacher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试 QueryWrapper 类的使用
 * <p>
 * 官网  <a href="https://mybatis.plus/guide/wrapper.html">...</a>
 *
 * @author Jion
 */
@Slf4j
@SpringBootTest
class QueryWrapperTest {

    @Autowired
    TeacherCurdMapper teacherCurdMapper;

    /**
     * 根据判断表达式是否成立, 进而生成动态SQL
     */
    @Test
    void condition() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        String name = "jion";
        // 在 name 不为空串的情况下, 动态SQL成立 SQL => SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 AND (name = ?)
        wrapper.eq(StringUtils.isNotBlank(name), "name", name);
        List<Teacher> result = teacherCurdMapper.selectList(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 指定查询字段
     * SELECT name,age FROM teacher WHERE deleted=0
     */
    @Test
    void select() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.select("name", "age");
        List<Teacher> result = teacherCurdMapper.selectList(wrapper);
        log.info("查询结果, {}", result);
    }


    /**
     * 测试,指定字段是否全部相等呢
     */
    @Test
    void allEq() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        Map<String, String> column = new HashMap<>();
        column.put("name", "Jion");
        column.put("age", null);
        // 全部相等 SQL => (name = ? AND age IS NULL)
        wrapper.allEq(column);
        List<Teacher> result = teacherCurdMapper.selectList(wrapper);
        log.info("查询结果, {}", result);

        // 忽略空,全部相等 SQL => (name = ?)
        wrapper = new QueryWrapper<>();
        wrapper.allEq(column, false);
        result = teacherCurdMapper.selectList(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 相等,比值查询
     * (name = ? AND name <> ? AND age > ? AND age >= ? AND age < ? AND age <= ?)
     */
    @Test
    void eq() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "jion")
                .ne("name", "jion")
                .gt("age", 18)
                .ge("age", 18)
                .lt("age", 20)
                .le("age", 20);
        List<Object> result = teacherCurdMapper.selectObjs(wrapper);
        log.info("查询结果, {}", result);
    }


    /**
     * 范围查询
     * (age BETWEEN ? AND ? AND age NOT BETWEEN ? AND ?)
     */
    @Test
    void between() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.between("age", 10, 20)
                .notBetween("age", 30, 40);
        List<Teacher> result = teacherCurdMapper.selectList(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 模糊查询
     * (name LIKE ? AND name NOT LIKE ? AND name LIKE ? AND name LIKE ?)
     */
    @Test
    void like() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.like("name", "jion")
                .notLike("name", "arise")
                .likeLeft("name", "j")
                .likeRight("name", "n");
        Long result = teacherCurdMapper.selectCount(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 判空查询
     * (name IS NOT NULL AND age IS NULL)
     */
    @Test
    void isNull() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNull("age");
        List<Teacher> result = teacherCurdMapper.selectList(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 范围查询
     * (age IN (?,?,?) AND age NOT IN (?,?))
     */
    @Test
    void in() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.in("age", 10, 11, 12)
                .notIn("age", 20, 21.22);
        List<Teacher> result = teacherCurdMapper.selectList(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 范围查询
     * (id IN (select id from teacher where id <= 2) AND age NOT IN (select age from teacher where id <= 2))
     */
    @Test
    void inSql() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", "select id from teacher where id <= 2")
                .notInSql("age", "select age from teacher where id <= 2");
        List<Object> result = teacherCurdMapper.selectObjs(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 存在查询
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 AND (EXISTS (select id from teacher where id = 1) AND NOT EXISTS (select age from teacher where id = 2))
     */
    @Test
    void exists() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.exists("select id from teacher where id = 1")
                .notExists("select age from teacher where id = 2");
        List<Object> result = teacherCurdMapper.selectObjs(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 排序
     * ORDER BY id ASC,age DESC,name DESC,workday ASC
     */
    @Test
    void orderByAsc() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id").orderByDesc(Arrays.asList("age", "name")).orderByAsc("workday");
        List<Teacher> result = teacherCurdMapper.selectList(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 分组查询, MySQL8的神奇语法
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 GROUP BY name,age
     */
    @Test
    void groupBy() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.groupBy(Arrays.asList("name", "age"));
        List<Teacher> result = teacherCurdMapper.selectList(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 分组过滤
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 GROUP BY name HAVING sum(age)> ?
     */
    @Test
    void having() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.groupBy("name")
                .having("sum(age)> {0}", 11);
        List<Teacher> result = teacherCurdMapper.selectList(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 同时, 将条件拼接到当前查询语句中.意义不大
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 AND (name = ? AND (age = ?))
     */
    @Test
    void and() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "jion").and(innerWrapper -> innerWrapper.eq("age", 18));
        Teacher result = teacherCurdMapper.selectOne(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 并列, 将条件拼接到当前查询语句中
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 AND (name = ? OR (age = ?))
     */
    @Test
    void or() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "jion").or(innerWrapper -> innerWrapper.eq("age", 18));
        List<Teacher> result = teacherCurdMapper.selectList(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 嵌套
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 AND (name = ? AND (age = ?))
     */
    @Test
    void nested() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "jion").nested(innerWrapper -> innerWrapper.eq("age", 18));
        Teacher result = teacherCurdMapper.selectOne(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 拼接原生的SQL
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 AND (date_format(workday,'%Y-%m-%d') = ? AND id = abs(?))
     */
    @Test
    void apply() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.apply("date_format(workday,'%Y-%m-%d') = {0}", "2021-02-01").apply("id = abs({0})", -1);
        Teacher result = teacherCurdMapper.selectOne(wrapper);
        log.info("查询结果, {}", result);
    }

    /**
     * 将当前SQL放到最后.
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 AND (name = ?) limit 0, 2
     */
    @Test
    void last() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "jion").last("limit 0, 2");
        List<Teacher> result = teacherCurdMapper.selectList(wrapper);
        log.info("查询结果, {}", result);
    }
}
