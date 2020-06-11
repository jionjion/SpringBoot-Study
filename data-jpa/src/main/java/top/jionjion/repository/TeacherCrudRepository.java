package top.jionjion.repository;

import org.springframework.data.repository.CrudRepository;
import top.jionjion.bean.Teacher;

/**
 *	使用JPARepository访问数据库
 *	通过继承CrudRepository接口或者使用@RepositoryDefinition 
 *	标识该类使用Spring-Data
 *
 * @author 14345
 */
public interface TeacherCrudRepository extends CrudRepository<Teacher,Integer>{

	
}
