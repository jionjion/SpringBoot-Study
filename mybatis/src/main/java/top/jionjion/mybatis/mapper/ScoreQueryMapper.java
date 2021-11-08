package top.jionjion.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import top.jionjion.mybatis.dto.Score;
import top.jionjion.mybatis.dto.Student;

import java.util.List;

/**
 * @author Jion
 */
public interface ScoreQueryMapper {

    /**
     * 通过学生ID查询
     *
     * @param sId 学生ID
     * @return 结果
     */
    List<Score> findScoreByStudentId(@Param("s_id") Integer sId);

    /**
     * 通过成绩ID联合查询
     *
     * @param cId 成绩ID
     * @return 联合结果
     */
    List<Score> findScoreAndStudentByScoreId(@Param("c_id") Integer cId);

    /**
     * 通过学生ID联合查询
     *
     * @param sId 学生ID
     * @return 联合结果
     */
    List<Student> findStudentAndScoreByStudentId(@Param("s_id") Integer sId);

    /**
     * 通过学生ID联合查询,
     * 多方绑定主表对象
     *
     * @param sId 学生ID
     * @return 联合结果
     */
    List<Student> findStudentAndScoreByStudentIdForObject(@Param("s_id") Integer sId);

}
