package top.jionjion.logging.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试日志使用
 *
 * @author Jion
 */
@SpringBootTest
class SomeServiceTest {

    @Autowired
    SomeService someService;

    /**
     * 日志
     */
    @Test
    void anything() {
        someService.anything();
    }
}