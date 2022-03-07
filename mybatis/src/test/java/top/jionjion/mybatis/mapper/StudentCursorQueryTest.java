package top.jionjion.mybatis.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import top.jionjion.mybatis.dto.Student;

import java.io.IOException;

/**
 * 流式查询
 *
 * @author Jion
 */
@Slf4j
@SpringBootTest
class StudentCursorQueryTest {

    @Autowired
    SqlSessionFactory sessionFactory;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    StudentCursorQuery cursorQuery;

    /**
     * 通过 SqlSessionFactory 进行流查询
     *
     * @throws Session 获取失败
     */
    @Test
    public void findAllBySqlSessionFactory() throws Exception {
        try (Cursor<Student> cursor = sessionFactory.openSession().getMapper(StudentCursorQuery.class).findAll()) {
            cursor.forEach(student -> log.info("流查询: {}", student));
        }
    }

    /**
     * 通过 TransactionTemplate  进行流查询
     */
    @Test
    public void findAllByTransactionTemplate() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(status -> {
            try (Cursor<Student> cursor = sessionFactory.openSession().getMapper(StudentCursorQuery.class).findAll()) {
                cursor.forEach(student -> log.info("流查询: {}", student));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    /**
     * 通过 @Transactional 进行流查询
     */
    @Test
    @Transactional
    public void findAllByTransactional() {
        Cursor<Student> cursor = cursorQuery.findAll();
        cursor.forEach(student -> log.info("流查询: {}", student));
    }

    /**
     * 如果不是手动执行开启数据库连接, 会在Mapper方法执行结束后自动管理
     */
    @Test
    public void findAll() {
        Cursor<Student> cursor = cursorQuery.findAll();
        for (Student student : cursor) {
            log.info("流查询: {}", student);
        }
        // 抛出 java.lang.IllegalStateException: A Cursor is already closed.
        Assertions.fail("未手动执行事物...");
    }
}
