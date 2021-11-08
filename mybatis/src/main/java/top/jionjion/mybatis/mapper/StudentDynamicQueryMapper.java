package top.jionjion.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import top.jionjion.mybatis.dto.Student;

import java.util.List;

/**
 * 动态SQL查询
 *
 * @author Jion
 */
public interface StudentDynamicQueryMapper {

    /**
     * 测试通过 IF 标签
     * @param id 主键
     * @return 结果
     */
    List<Student> findStudentByIf(@Param("id") Integer id);

    /**
     *  测试通过 choose, when, otherwise 标签
     * @param student 查询用例
     * @return 结果
     */
    List<Student> findStudentByExampleChoose(@Param("student") Student student);

    /**
     *  测试通过 where 标签
     * @param student 查询用例
     * @return 结果
     */
    List<Student> findStudentByExampleWhere(@Param("student") Student student);

    /**
     * 测试通过 foreach 标签
     * @param ids 主键列表
     * @return 结果
     */
    List<Student> findStudentByForeach(@Param("ids") List<Integer> ids);
}
