package top.jionjion.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.jionjion.JpaApplicationTest;
import top.jionjion.bean.Teacher;

import java.util.Date;
import java.util.Optional;

public class TeacherCrudRepositoryTest extends JpaApplicationTest {

	@Autowired
	TeacherCrudRepository teacherCrudRepository;
	

	/**
	 * 	查询当前总记录数
	 */
	@Test
	public void testCount() {
		long count = teacherCrudRepository.count();
		System.out.println("总记录数:" + count);
	}

	/**
	 * 	删除当前数据表
	 */
	@Test
	public void testDeleteAll() {
		teacherCrudRepository.deleteAll();
	}

	/**
	 * 	保存实体
	 */
	@Test
	public void testSaveS() {
		Teacher teacher = new Teacher();
		teacher.setId(7);
		teacher.setName("Per");
		teacher.setAge(20);
		teacher.setAddress("开封");
		teacher.setWorkday(new Date());
		teacherCrudRepository.save(teacher);
	}

	/**
	 * 	通过主键查询
	 */
	@Test
	public void testFindOneInteger() {
		Optional<Teacher> teacher = teacherCrudRepository.findById(1);
		System.out.println("查询第一个:" + teacher);
	}

	/**
	 * 	通过主键判断
	 */
	@Test
	public void testExistsInteger() {
		boolean exists = teacherCrudRepository.existsById(1);
		System.out.println("第一个是否存在:" + exists);
	}

	/**
	 * 	查询全部方法
	 * 	输出一个实现了Iterable<T>接口的实体对象,这里直接调用其迭代器进行迭代输出
	 */
	@Test
	public void testFindAll() {
		for (Teacher teacher : teacherCrudRepository.findAll()) {
			System.out.println("迭代下一个:" + teacher);
		}
	}


	/**
	 * 	根据主键删除
	 */
	@Test
	public void testDeleteInteger() {
		teacherCrudRepository.deleteById(7);
	}

	/**
	 *	通过实体删除
	 */
	@Test
	public void testDeleteTeacher() {
		Optional<Teacher> teacher = teacherCrudRepository.findById(8);
		teacher.ifPresent(value -> teacherCrudRepository.delete(value));
	}

	/**
	 * 	通过迭代器删除全部
	 */
	@Test
	public void testDeleteIterableTeacher() {
		Iterable<Teacher> teachers = teacherCrudRepository.findAll(); 
		teacherCrudRepository.deleteAll(teachers);
	}

}
