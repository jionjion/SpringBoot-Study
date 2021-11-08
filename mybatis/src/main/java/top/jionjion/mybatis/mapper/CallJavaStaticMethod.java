package top.jionjion.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * 调用java的方法
 *
 * @author Jion
 */
public interface CallJavaStaticMethod {

    /**
     *  调用Java的静态方法
     * @param name 调用参数
     */
    void findStudentByName(@Param("name") String name);
}
