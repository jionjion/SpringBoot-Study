package top.jionjion.jpa.bean;

import lombok.Data;

import java.util.Date;

/**
 *	学生类的数据库对象模型
 *
 * @author JionJion
 */
@Data
public class Student {

	private int id;
	
	private String name;
	
	private int age;
	
	private String address;
	
	private Date birthday;
}
