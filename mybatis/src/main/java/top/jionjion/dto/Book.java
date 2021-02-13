package top.jionjion.dto;

import lombok.Data;

/**
 *  图书的数据模型,多对多
 * @author Jion
 */
@Data
public class Book {

    /** 主键 */
    private Integer id;
    /** 学生ID */
    private Integer sId;
    /** 书名 */
    private String name;
    /** 描述 */
    private String description;
}
