package top.jionjion.mybatis.mapper;

import java.util.Map;

/**
 *  调用存储过程
 * @author Jion
 */
public interface CallMapper {


    /**
     * 调用函数,具有返回值. 需要将参数和结果进行封装
     *
     * @param param 参数
     * @return 结果,两参数求和
     */
    Integer callFunctionOneAddOne(Map<String, Integer> param);

    /**
     * 调用存储过程. 需要将参数和结果进行封装
     *
     * @param param 参数
     * @return 结果,两参数求和
     */
    Integer callProcedureOneAddOne(Map<String, Integer> param);
}
