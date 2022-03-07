package top.jionjion.mybatis.mapper;

import org.apache.ibatis.cursor.Cursor;
import top.jionjion.mybatis.dto.Student;

/**
 * 流查询
 *
 * @author Jion
 */
public interface StudentCursorQuery {

    /**
     * 查询全部, 流查询
     *
     * @return 结果
     */
    Cursor<Student> findAll();
}