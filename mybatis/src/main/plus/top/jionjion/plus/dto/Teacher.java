package top.jionjion.plus.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * Mybatis-plus 插件使用
 *
 * @author JionJion
 */
@Data
@TableName("teacher")
public class Teacher {

    /**
     * 主键, 子增序列
     */
    @TableId(type = IdType.AUTO)
    @TableField("id")
    private Integer id;

    /**
     * 名字
     */
    @TableField("name")
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

    /**
     * 乐观锁,在每次更新时执行
     */
    @Version
    private Integer version;

    /**
     * 是否逻辑删除
     */
    @TableLogic
    private Integer deleted;

    /**
     * 最后修改日期,默认转托驼峰命名
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 最后修改日期,指定字段名
     */
    @TableField(value = "modify_date", fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;

}
