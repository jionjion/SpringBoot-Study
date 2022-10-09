package top.jionjion.jpa.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import top.jionjion.jpa.bean.Teacher;

import java.util.*;

/**
 * 使用SpringTemplate模板方法访问数据库
 * Spring-Data框架
 */
@Slf4j
@Rollback
@Transactional
@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;


    @Test
    void testFindByName() {
        try {
            Teacher teacher = teacherRepository.findByName("JionJion");
            System.out.println(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFindByNameStartsWithAndAgeLessThan() {
        try {
            List<Teacher> teachers = teacherRepository.findByNameStartsWithAndAgeLessThan("Jion", 30);
            System.out.println(teachers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFindByNameEndingWithAndAgeGreaterThanEqual() {
        try {
            List<Teacher> teachers = teacherRepository.findByNameEndingWithAndAgeGreaterThanEqual("Jion", 23);
            System.out.println(teachers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFindByNameInOrAddressNotIn() {
        try {
            List<String> names = new ArrayList<>();
            names.add("JionJion");
            names.add("Arise");
            List<String> addresses = new ArrayList<>();
            addresses.add("鹤壁");
            addresses.add("信阳");
            List<Teacher> teachers = teacherRepository.findByNameInOrAddressNotIn(names, addresses);
            System.out.println(teachers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFindByWorkdayBetween() {
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
    void testFindByIdNotNullAndNameIsNotIn() {
        try {
            List<Teacher> teachers = teacherRepository.findByIdNotNullAndNameIsNull();
            System.out.println(teachers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}