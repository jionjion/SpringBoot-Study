package top.jionjion.mapper;

import org.apache.ibatis.annotations.Param;
import top.jionjion.bean.Student;

/**
 * @author Jion
 */
public interface StudentMapper {

    /**
     *  通过ID查询
     * @param id 主键
     * @return 查询结果
     */
    Student findByUserId(@Param("id") Integer id);
}
