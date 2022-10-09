package top.jionjion.jpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * 单元测试
 *
 * @author Jion
 */
@Slf4j
@Rollback
@Transactional
@SpringBootTest
class JpaApplicationTest {

    @Test
    void run(){

    }
}