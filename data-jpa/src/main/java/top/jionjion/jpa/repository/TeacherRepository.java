package top.jionjion.jpa.repository;

import org.springframework.data.repository.Repository;
import top.jionjion.jpa.bean.Teacher;

import java.util.Date;
import java.util.List;


/**
 * 使用JPARepository访问数据库
 * 通过继承Repository接口或者使用@RepositoryDefinition
 * 标识该类使用Spring-Data
 * 通过方法签名,实现查询
 *
 * @author JionJion
 */
public interface TeacherRepository extends Repository<Teacher, Integer> {

    /**
     * 根据姓名查询
     * select * from teacher where name = ?
     *
     * @param name 姓名
     * @return 结果
     */
    Teacher findByName(String name);

    /**
     * 姓氏开头,且年龄小于
     * select * from teacher where name like ?% and age < ?
     *
     * @param name 姓名
     * @param age  年龄
     * @return 结果
     */
    List<Teacher> findByNameStartsWithAndAgeLessThan(String name, Integer age);

    /**
     * 名字结尾,年龄大于等于
     * select * from teacher where name like %> and age >= ?
     *
     * @param name 姓名
     * @param age  年龄
     * @return 结果
     */
    List<Teacher> findByNameEndingWithAndAgeGreaterThanEqual(String name, Integer age);

    /**
     * 在/不在某个枚举中
     * select * from teacher where name in (? , ?) or address not in (? , ?)
     *
     * @param names     姓名列表
     * @param addresses 地址列表
     * @return 结果
     */
    List<Teacher> findByNameInOrAddressNotIn(List<String> names, List<String> addresses);

    /**
     * 日期范围
     * select * from teacher where workday between ? and ?
     *
     * @param start 起始日期
     * @param end   结束日期
     * @return 结果
     */
    List<Teacher> findByWorkdayBetween(Date start, Date end);

    /**
     * 非空查询
     * select * from teacher where id is not null and name is null
     *
     * @return 结果
     */
    List<Teacher> findByIdNotNullAndNameIsNull();
}
