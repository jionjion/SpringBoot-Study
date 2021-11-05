package top.jionjion.jpa.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.RepositoryDefinition;
import top.jionjion.jpa.bean.Teacher;

/**
 * 使用JPARepository访问数据库
 * 通过继承PagingAndSortingRepository接口或者使用@RepositoryDefinition
 * 标识该类使用Spring-Data
 *
 * @author JionJion
 */
@RepositoryDefinition(domainClass = Teacher.class, idClass = Integer.class)
public interface TeacherJpaSpecificationExecutorRepository extends JpaSpecificationExecutor<Teacher> {


}
