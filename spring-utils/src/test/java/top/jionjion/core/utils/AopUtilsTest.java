package top.jionjion.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.core.utils.service.HomeService;

/**
 * AopUtils 代理工具类
 *
 * @author Jion
 */
@Slf4j
@SpringBootTest
public class AopUtilsTest {

    @Autowired
    HomeService homeService;

    /**
     * 判断代理类型
     */
    @Test
    public void testA() {
        // 判断是不是 Spring 代理对象
        log.info("判断是不是 Spring 代理对象: {}", AopUtils.isAopProxy(homeService));
        // 判断是不是 jdk 动态代理对象
        log.info("判断是不是 jdk 动态代理对象: {}", AopUtils.isJdkDynamicProxy(homeService));
        // 判断是不是 CGLIB 代理对象
        log.info("判断是不是 CGLIB 代理对象: {}", AopUtils.isCglibProxy(homeService));
    }

    /**
     * 获取被代理对象的 class
     */
    @Test
    public void testB() {
        // 获取被代理的目标 class
        log.info("获取被代理的目标的类类型: {}", AopUtils.getTargetClass(homeService));
    }
}
