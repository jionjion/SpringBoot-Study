package top.jionjion.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.dto.Teacher;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试 Wrapper 类的使用
 * <p>
 * 官网  https://mybatis.plus/guide/wrapper.html
 *
 * @author Jion
 */
@Slf4j
@SpringBootTest
public class QueryWrapperTest {

    @Autowired
    TeacherCurdMapper teacherCurdMapper;

    /**
     * 根据判断表达式是否成立, 进而生成动态SQL
     */
    @Test
    public void condition() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        String name = "jion";
        // 在 name 不为空串的情况下, 动态SQL成立 SQL => SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 AND (name = ?)
        wrapper.eq(StringUtils.isNotBlank(name), "name", name);
        teacherCurdMapper.selectList(wrapper);
    }

    /**
     * 测试,指定字段是否全部相等呢
     */
    @Test
    public void allEq() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        Map<String, String> column = new HashMap<>();
        column.put("name", "Jion");
        column.put("age", null);
        // 全部相等 SQL => (name = ? AND age IS NULL)
        wrapper.allEq(column);
        teacherCurdMapper.selectOne(wrapper);

        // 忽略空,全部相等 SQL => (name = ?)
        wrapper = new QueryWrapper<>();
        wrapper.allEq(column, false);
        teacherCurdMapper.selectOne(wrapper);
    }

    /**
     * 相等,比值查询
     * (name = ? AND name <> ? AND age > ? AND age >= ? AND age < ? AND age <= ?)
     */
    @Test
    public void eq() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "jion")
                .ne("name", "jion")
                .gt("age", 18)
                .ge("age", 18)
                .lt("age", 20)
                .le("age", 20);
        teacherCurdMapper.selectObjs(wrapper);
    }


    /**
     * 范围查询
     * (age BETWEEN ? AND ? AND age NOT BETWEEN ? AND ?)
     */
    @Test
    public void betweent() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.between("age", 10, 20)
                .notBetween("age", 30, 40);
        teacherCurdMapper.selectList(wrapper);
    }

    /**
     * 模糊查询
     * (name LIKE ? AND name NOT LIKE ? AND name LIKE ? AND name LIKE ?)
     */
    @Test
    public void like() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.like("name", "jion")
                .notLike("name", "arise")
                .likeLeft("name", "j")
                .likeRight("name", "n");
        teacherCurdMapper.selectCount(wrapper);
    }

    /**
     * 判空查询
     * (name IS NOT NULL AND age IS NULL)
     */
    @Test
    public void isNull() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNull("age");
        teacherCurdMapper.selectList(wrapper);
    }

    /**
     * 范围查询
     * (age IN (?,?,?) AND age NOT IN (?,?))
     */
    @Test
    public void in() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.in("age", 10, 11, 12)
                .notIn("age", 20, 21.22);
        teacherCurdMapper.selectList(wrapper);
    }

    /**
     * 范围查询
     * (id IN (select id from teacher where id <= 2) AND age NOT IN (select age from teacher where id <= 2))
     */
    @Test
    public void inSql() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", "select id from teacher where id <= 2")
                .notInSql("age", "select age from teacher where id <= 2");
        teacherCurdMapper.selectObjs(wrapper);
    }


    /**
     * 排序
     * ORDER BY id ASC,age DESC,name DESC,workday ASC
     */
    @Test
    public void orderByAsc() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id").orderByDesc("age", "name").orderByAsc("workday");
        teacherCurdMapper.selectList(wrapper);
    }

    /**
     * 分组查询, MySQL8的神奇语法
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 GROUP BY name,age
     */
    @Test
    public void groupBy() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.groupBy("name", "age");
        teacherCurdMapper.selectList(wrapper);
    }

    /**
     * 分组过滤
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 GROUP BY name HAVING sum(age)> ?
     */
    @Test
    public void having() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.groupBy("name")
                .having("sum(age)> {0}", 11);
        teacherCurdMapper.selectList(wrapper);
    }

    /**
     * 同时, 将条件拼接到当前查询语句中..意义不大
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 AND (name = ? AND (age = ?))
     */
    @Test
    public void and() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "jion").and(innerWrapper -> innerWrapper.eq("age", 18));
        teacherCurdMapper.selectOne(wrapper);
    }

    /**
     * 并列, 将条件拼接到当前查询语句中
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 AND (name = ? OR (age = ?))
     */
    @Test
    public void or() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "jion").or(innerWrapper -> innerWrapper.eq("age", 18));
        teacherCurdMapper.selectList(wrapper);
    }

    /**
     * 嵌套
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 AND (name = ? AND (age = ?))
     */
    @Test
    public void nested() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "jion").nested(innerWrapper -> innerWrapper.eq("age", 18));
        teacherCurdMapper.selectOne(wrapper);
    }

    /**
     * 拼接原生的SQL
     * SELECT id,name,workday,address,age,version,deleted,create_date,modify_date FROM teacher WHERE deleted=0 AND (date_format(workday,'%Y-%m-%d') = ? AND id = abs(?))
     */
    @Test
    public void apply() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.apply("date_format(workday,'%Y-%m-%d') = {0}", "2021-02-01").apply("id = abs({0})", -1);
        teacherCurdMapper.selectOne(wrapper);
    }


}
