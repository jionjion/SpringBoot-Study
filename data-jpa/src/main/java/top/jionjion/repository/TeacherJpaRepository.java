package top.jionjion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jionjion.bean.Teacher;


/**
 * 使用JPARepository访问数据库
 * 通过继承JpaRepository接口或者使用@RepositoryDefinition
 * 标识该类使用Spring-Data
 *
 * @author JionJion
 */
public interface TeacherJpaRepository extends JpaRepository<Teacher, Integer> {


}
