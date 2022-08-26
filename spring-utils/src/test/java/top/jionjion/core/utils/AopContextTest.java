package top.jionjion.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.AopContext;

/**
 * 代理对象.
 *
 * @author Jion
 */
@Slf4j
class AopContextTest {

    /**
     * 获取当前对象的代理对象
     */
    @Test
    void test() {
        Object obj = AopContext.currentProxy();
        log.info("获得代理对象: {}", obj);
    }
}
