package top.jionjion.bean;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 *	学生类的数据库对象模型
 *
 * @author JionJion
 */
@Data
public class Student {

	/** 主键 */
	private int id;
	/** 姓名 */
	private String name;
	/** 年龄 */
	private int age;
	/** 地址 */
	private String address;
	/** 生日 */
	private LocalDate birthday;
	/** 成绩 */
	private List<Score> scores;
}
