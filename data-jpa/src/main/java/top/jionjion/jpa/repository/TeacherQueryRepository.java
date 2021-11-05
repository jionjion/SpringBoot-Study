package top.jionjion.jpa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import top.jionjion.jpa.bean.Teacher;

/**
 * 使用JPARepository访问数据库
 * 通过继承Repository接口或者使用@RepositoryDefinition
 * 标识该类使用Spring-Data
 * 通过使用@Query注解,重写查询语句
 *
 * @author JionJion
 */
@RepositoryDefinition(domainClass = Teacher.class, idClass = Integer.class)
public interface TeacherQueryRepository {


    /* *****************************|
     * 			HQL语句				|
     * *****************************/

    /**
     * 查询最大值
     * select t from Teacher t where id = (select max(id) from Teacher)
     *
     * @return 结果
     */
    @Query("select t from Teacher t where t.id = (select max(id) from Teacher)")
    Teacher getTeacherByMaxId();

    /**
     * 根据姓名查询
     * select t from Teacher t where t.name = ?
     *
     * @param name 姓名
     * @return 结果
     */
    @Query("select t from Teacher t where t.name = ?1")
    Teacher getTeacherByParamName(String name);

    /**
     * 根据地址查询
     * select t from Teacher t where t.address = ?
     *
     * @param address 地址
     * @return 结果
     */
    @Query("select t from Teacher t where t.address = :address")
    Teacher getTeacherByParamAddress(@Param("address") String address);

    /**
     * 修改数据 添加@Modifying注解和事务开启
     * update Teacher t set t.age = :age where t.id = :id
     *
     * @param id  主键
     * @param age 年龄
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update Teacher t set t.age = :age where t.id = :id")
    void updateSetName(@Param("id") Integer id, @Param("age") Integer age);


    /* ******************************|
     * 			SQL语句				|
     * ******************************/

    /**
     * 使用原生的SQL进行查询.需要开启nativeQuery注解属性
     * select count(*) from teacher
     *
     * @return 结果
     */
    @Query(value = "select count(*) from teacher", nativeQuery = true)
    Long getCount();
}
