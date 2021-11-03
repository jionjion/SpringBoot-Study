package top.jionjion.logback.service;

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

    /**
     * 抛出自定义异常
     */
    @Test
    void throwException() {
        someService.throwException();
    }

    /**
     * 抛出异常,同时纪录关键字,生成对应日志级别
     */
    @Test
    void throwExceptionForSift() {
        someService.throwExceptionForSift();
    }

}