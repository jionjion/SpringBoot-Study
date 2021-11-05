package top.jionjion.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import top.jionjion.jdbc.bean.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *	使用SpringTemplate模板方法访问数据库
 *	Spring-Data框架
 * @author JionJion
 */
@Component
public class StudentTemplate {

	private final JdbcTemplate jdbcTemplate;

	public StudentTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	List<Student> queryStudentList() {
		//匿名内部变量
		final List<Student> students = new ArrayList<>();
		String sql = "select id , name , age , address , birthday from student";
		//执行查询,并对返回结果行进行匿名函数处理
		jdbcTemplate.query(sql, resultSet -> {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int age = resultSet.getInt("age");
			String address = resultSet.getString("address");
			LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
			Student student = new Student();
			student.setId(id);
			student.setName(name);
			student.setAge(age);
			student.setAddress(address);
			student.setBirthday(birthday);
			students.add(student);
		});
		return students;
	}
	
	void saveStudent(Student student) {
		String sql = "insert into student(id,name,age,address,birthday) values (? , ? , ? , ? , ?)";
		jdbcTemplate.update(sql, student.getId(),student.getName(),student.getAge(),student.getAddress(),student.getBirthday());
	}
}
