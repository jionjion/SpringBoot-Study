package top.jionjion.mapper;

import org.apache.ibatis.annotations.Param;
import top.jionjion.bean.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author Jion
 */
public interface StudentQueryMapper {

    /**
     *  通过ID查询
     * @param id 主键
     * @return 结果
     */
    Student findStudentById(@Param("id") Integer id);

    /**
     *  通过Name查询,字符
     * @param name 姓名
     * @return 结果
     */
    List<Student> findStudentByName(String name);

    /**
     *  通过Name查询, 模糊查询
     * @param name 姓名
     * @return 结果
     */
    List<Student> findStudentByLikeName(String name);

    /**
     *  通过Birthday查询, 日期查询
     * @param birthday 生日, 日期
     * @return 结果
     */
    List<Student> findStudentByBirthdayDate(LocalDate birthday);

    /**
     *  通过Birthday查询 字符转日期查询
     * @param birthday 生日,字符串
     * @return 结果
     */
    List<Student> findStudentByBirthdayStr(String birthday);

    /**
     *  通过Birthday范围查询, 字符范围
     * @param birthdayFrom 日期字符从
     * @param birthdayTo  日期字符到
     * @return 结果
     */
    List<Student> findStudentByBirthdayBetween(String birthdayFrom, String birthdayTo);

    /**
     *  通过ID范围查询, 数字范围
     * @param idFrom 主键从
     * @param idTo 主键到
     * @return 结果
     */
    List<Student> findStudentByIdBetween(int idFrom, int idTo);

    /**
     *  查询全部数据总数
     * @return 结果
     */
    Long findCount();

    /**
     *  查询包含有伪列的数据
     * @return 结果
     */
    List<Map> findRow();

    /**
     *  通过ID范围in查询, 数字范围
     * @param ids 主键范围
     * @return 结果
     */
    List<Student> findStudentByIdIn(List<Integer> ids);

    /**
     *  通过ID查询大小于, 数字范围
     * @param id 主键
     * @return 结果
     */
    List<Student> findStudentByIdLt(Integer id);

    /**
     *  判空查询
     * @return 结果
     */
    List<Student> findStudentByAgeNull();

    /**
     *  查询排序
     * @return 结果
     */
    List<Student> findAllOrderByIdDesc();

    /**
     *  分页查询
     * @param index 页首纪录
     * @param pageSize 分页大小
     * @return 结果
     */
    List<Student> findAllLimit(int index,  int pageSize);
}
