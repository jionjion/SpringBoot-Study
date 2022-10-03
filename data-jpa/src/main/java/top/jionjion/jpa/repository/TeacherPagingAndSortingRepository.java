package top.jionjion.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import top.jionjion.jpa.bean.Teacher;

/**
 * 使用JPARepository访问数据库
 * 通过继承PagingAndSortingRepository接口或者使用@RepositoryDefinition
 * 标识该类使用Spring-Data
 *
 * @author JionJion
 */
@Repository
public interface TeacherPagingAndSortingRepository extends PagingAndSortingRepository<Teacher, Integer> {


}
