package top.jionjion.dto;

import lombok.Data;

import java.util.Date;

/**
 * Mybatis-plus 插件使用
 *
 * @author JionJion
 */
@Data
public class Teacher {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 工作日
     */
    private Date workday;

    /**
     * 地址
     */
    private String address;

    /**
     * 年龄
     */
    private Integer age;
}
