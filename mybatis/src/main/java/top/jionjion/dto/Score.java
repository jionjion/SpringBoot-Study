package top.jionjion.dto;

import lombok.Data;

/**
 *  成绩类对应的数据模型, 一对多
 * @author Jion
 */
@Data
public class Score{

    /** ID */
    Integer id;
    /** 学生ID */
    Integer sId;
    /** 科目 */
    String course;
    /** 分数 */
    Float grade;
    /** 学生,主表信息 */
    Student student;
}
