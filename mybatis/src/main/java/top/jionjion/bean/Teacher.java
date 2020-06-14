package top.jionjion.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *	数据库表对应的实体类
 *	注意使用包装类型替换基本类型
 *	数据库表在创建时随项目启动而创建
 *	JPA定义规范,Hibernate各种实现,ORM框架映射
 *
 * 	@author JionJion
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {

	private Integer id;
	
	private String name;
	
	private Date workday;
	
	private String address;
	
	private Integer age;
}
