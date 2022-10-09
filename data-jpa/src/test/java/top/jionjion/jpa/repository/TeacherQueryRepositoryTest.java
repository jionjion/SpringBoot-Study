package top.jionjion.jpa.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import top.jionjion.jpa.bean.Teacher;

/**
 * 使用SpringTemplate模板方法访问数据库
 * Spring-Data框架
 */
@Slf4j
@Rollback
@Transactional
@SpringBootTest
class TeacherQueryRepositoryTest {

    @Autowired
    private TeacherQueryRepository teacherQueryRepository;


    @Test
    void testGetTeacherByMaxId() {
        try {
            Teacher teacher = teacherQueryRepository.getTeacherByMaxId();
            System.out.println(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetTeacherByParamName() {
        try {
            Teacher teacher = teacherQueryRepository.getTeacherByParamName("JionJion");
            System.out.println(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetTeacherByParamAddress() {
        try {
            Teacher teacher = teacherQueryRepository.getTeacherByParamAddress("鹤壁");
            System.out.println(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetCount() {
        try {
            Long count = teacherQueryRepository.getCount();
            System.out.println("总记录数:" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testUpdateSetName() {
        try {
            teacherQueryRepository.updateSetName(2, 18);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}