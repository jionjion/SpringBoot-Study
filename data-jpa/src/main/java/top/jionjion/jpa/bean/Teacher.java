package top.jionjion.jpa.bean;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 数据库表对应的实体类
 * 注意使用包装类型替换基本类型
 * 数据库表在创建时随项目启动而创建
 * JPA定义规范,Hibernate各种实现,ORM框架映射
 *
 * @author JionJion
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Teacher {

    /**
     * 主键
     * 自动生成数据库对应的序列表
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 姓名
     * 长度,非空
     */
    @Column(length = 20, nullable = false)
    private String name;

    /**
     * 字段名
     */
    @Column(name = "workday")
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
