package top.jionjion.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.jionjion.JpaApplicationTest;
import top.jionjion.bean.Teacher;

import java.util.*;

/**
 *	使用SpringTemplate模板方法访问数据库
 *	Spring-Data框架
 */
public class TeacherRepositoryTest extends JpaApplicationTest {
	
	@Autowired
    TeacherRepository teacherRepository;
	

	@Test
	public void testFindByName() {
		try {
			Teacher teacher = teacherRepository.findByName("JionJion");
			System.out.println(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindByNameStartsWithAndAgeLessThan() {
		try {
			List<Teacher> teachers = teacherRepository.findByNameStartsWithAndAgeLessThan("Jion", 30);
			System.out.println(teachers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindByNameEndingWithAndAgeGreaterThanEqual() {
		try {
			List<Teacher> teachers = teacherRepository.findByNameEndingWithAndAgeGreaterThanEqual("Jion", 23);
			System.out.println(teachers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindByNameInOrAddressNotIn() {
		try {
			List<String> names = new ArrayList<>();
			names.add("JionJion");
			names.add("Arise");
			List<String> addresses = new ArrayList<>();
			addresses.add("鹤壁");
			addresses.add("信阳");
			List<Teacher> teachers = teacherRepository.findByNameInOrAddressNotIn(names,addresses);
			System.out.println(teachers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	public void testFindByWorkdayBetween() {
		try {
			List<Teacher> teachers = teacherRepository.findByWorkdayBetween(
					new Date(new GregorianCalendar(2017, Calendar.NOVEMBER, 15).getTimeInMillis()),
					new Date(new GregorianCalendar(2017, Calendar.NOVEMBER, 22).getTimeInMillis()));
			System.out.println(teachers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindByIdNotNullAndNameIsNotIn() {
		try {
			List<Teacher> teachers = teacherRepository.findByIdNotNullAndNameIsNull();
			System.out.println(teachers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}