package top.jionjion.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.jionjion.mybatis.dto.Teacher;

import java.util.List;

/**
 * 使用 Mybatis-plus 进行Curd操作
 *
 * @author Jion
 */
public interface TeacherCurdMapper extends BaseMapper<Teacher> {

    /**
     * 通过注解自定义SQL
     *
     * @param wrapper 查询条件
     * @return 结果
     */
    @Select("select * from teacher ${ew.customSqlSegment}")
    List<Teacher> findListByAnnotation(@Param(Constants.WRAPPER) Wrapper<Teacher> wrapper);

    /**
     * 通过配置文件自定义SQL
     *
     * @param wrapper 查询条件
     * @return 结果
     */
    List<Teacher> findListByXml(@Param(Constants.WRAPPER) Wrapper<Teacher> wrapper);
}
