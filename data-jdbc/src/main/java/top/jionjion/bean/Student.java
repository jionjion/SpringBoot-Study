package top.jionjion.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 *	学生类的数据库对象模型
 *
 * @author JionJion
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private int id;
	
	private String name;
	
	private int age;
	
	private String address;
	
	private LocalDate birthday;
}
