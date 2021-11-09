package top.jionjion.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import top.jionjion.jpa.JpaApplicationTest;
import top.jionjion.jpa.bean.Teacher;

import javax.persistence.criteria.*;
import java.util.Optional;

import static org.assertj.core.api.Assertions.fail;


/**
 *	真难用啊QvQ
 */
public class TeacherJpaSpecificationExecutorRepositoryTest extends JpaApplicationTest {

	@Autowired
	TeacherJpaSpecificationExecutorRepository teacherJpaSpecificationExecutorRepository;
	
	/**
	 * 	查询第一个
	 * 	排序规则:主键小于等于1
	 * 	返回值必须唯一或者为空
	 */
	@Test
	public void testFindOne() {
		Specification<Teacher> specification = (root, query, cb) -> {
			//泛型指定为字段类型
			Path<Integer> path = root.get("id");
			//主键小于等于1
			return cb.lessThanOrEqualTo(path, 1);
		};
		Optional<Teacher> teacher = teacherJpaSpecificationExecutorRepository.findOne(specification);
		System.out.println("年龄小于等于20的第一个:" + teacher);
	}

	@Test
	public void testFindAllSpecificationOfT() {
		fail("Not yet implemented");
	}

	/**
	 * 	测试 
	 * 	指定排序规则和分页规则
	 */
	@Test
	public void testFindAllSpecificationOfTPageable() {
		//匿名内部类,完成根据id降序排列
		Sort.Order orders = new Sort.Order(Sort.Direction.DESC,"id");
		Sort sort = Sort.by(orders);
		
		//分页查询,第一页,显示三个
		Pageable pageable = PageRequest.of(0, 3,sort);
		
		//排序规则
		Specification<Teacher> specification = (root, query, cb) -> {
			//泛型指定为字段类型
			Path<Integer> path = root.get("age");
			//年龄大于23
			return cb.gt(path, 20);
		};
		
		Page<Teacher> page = teacherJpaSpecificationExecutorRepository.findAll(specification,pageable);
		System.out.println("总页数:" + page.getTotalPages());
		System.out.println("总记录数:" + page.getTotalElements());
		System.out.println("当前页数:" + page.getNumber());					//从0开始
		System.out.println("当前页面记录数:" + page.getNumberOfElements());
		System.out.println("当前页面的集合:" + page.getContent());	
	}

	@Test
	public void testFindAllSpecificationOfTSort() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

}
