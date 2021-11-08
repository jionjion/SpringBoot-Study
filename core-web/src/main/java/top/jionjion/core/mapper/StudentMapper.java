package top.jionjion.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.jionjion.core.bean.Student;

/**
 * @author Jion
 */
@Mapper
public interface StudentMapper {

    /**
     *  通过ID查询
     * @param id 主键
     * @return 结果
     */
    Student findStudentById(@Param("id") Integer id);
}
