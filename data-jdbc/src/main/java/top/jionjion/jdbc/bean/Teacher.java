package top.jionjion.jdbc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 *	数据库表对应的实体类
 *	注意使用包装类型替换基本类型
 *	数据库表在创建时随项目启动而创建
 *
 * 	@author JionJion
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

	private Integer id;
	
	private String name;
	
	private LocalDate workday;
	
	private String address;
	
	private Integer age;
}
