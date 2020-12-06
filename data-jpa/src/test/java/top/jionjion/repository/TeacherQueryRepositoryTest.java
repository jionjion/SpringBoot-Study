package top.jionjion.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.jionjion.JpaApplicationTest;
import top.jionjion.bean.Teacher;

/**
 *	使用SpringTemplate模板方法访问数据库
 *	Spring-Data框架
 */
public class TeacherQueryRepositoryTest extends JpaApplicationTest {
	
	@Autowired
	private TeacherQueryRepository teacherQueryRepository;
	
	@Test
	public void testGetTeacherByMaxId() {
		try {
			Teacher teacher = teacherQueryRepository.getTeacherByMaxId();
			System.out.println(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetTeacherByParamName() {
		try {
			Teacher teacher = teacherQueryRepository.getTeacherByParamName("JionJion");
			System.out.println(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	@Test
	public void testGetTeacherByParamAddress() {
		try {
			Teacher teacher = teacherQueryRepository.getTeacherByParamAddress("鹤壁");
			System.out.println(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	public void testGetCount() {
		try {
			Long count = teacherQueryRepository.getCount();
			System.out.println("总记录数:"+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
	
	@Test
	public void testUpdateSetName() {
		try {
			teacherQueryRepository.updateSetName(2, 18);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
}