package top.jionjion.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.jionjion.web.bean.Student;

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
