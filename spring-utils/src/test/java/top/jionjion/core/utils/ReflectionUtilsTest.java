package top.jionjion.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ReflectionUtils;
import top.jionjion.core.utils.service.HomeService;
import top.jionjion.core.utils.service.impl.HomeServiceImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ReflectionUtils 反射工具包
 *
 * @author Jion
 */
@Slf4j
@SpringBootTest
class ReflectionUtilsTest {

    @Autowired
    HomeService homeService;

    /**
     * 获取方法
     */
    @Test
    void testA() throws NoSuchMethodException {
        // 在类中查找指定方法
        ReflectionUtils.findMethod(HomeService.class, "hello");

        // 同上  额外提供方法参数类型作查找条件
        ReflectionUtils.findMethod(HomeService.class, "hello", String.class);

        // 获得类中所有方法  包括继承而来的
        ReflectionUtils.getAllDeclaredMethods(HomeService.class);

        // 在类中查找指定构造方法
        ReflectionUtils.accessibleConstructor(HomeServiceImpl.class);
    }

    @Test
    void testB() {
        Method helloMethod = ReflectionUtils.findMethod(HomeService.class, "hello", String.class);
        assert helloMethod != null;

        // 检查一个方法是否声明抛出指定异常
        log.info("是否声明抛出指定异常: {}", ReflectionUtils.declaresException(helloMethod, Exception.class));

        // 是否是 equals() 方法
        log.info("是否是 equals() 方法: {}", ReflectionUtils.isEqualsMethod(helloMethod));

        // 是否是 hashCode() 方法
        log.info("是否是 hashCode() 方法: {}", ReflectionUtils.isHashCodeMethod(helloMethod));

        // 是否是 toString() 方法
        log.info("是否是 toString() 方法: {}", ReflectionUtils.isToStringMethod(helloMethod));

        // 是否是从 Object 类继承而来的方法
        log.info("是否是 Object 类继承而来的方法 方法: {}", ReflectionUtils.isObjectMethod(helloMethod));
    }

    /**
     * 执行方法
     */
    @Test
    void testC() throws NoSuchMethodException {
        Constructor<HomeServiceImpl> homeServiceConstructor = ReflectionUtils.accessibleConstructor(HomeServiceImpl.class);
        Method sayMethod = ReflectionUtils.findMethod(HomeService.class, "say");
        assert sayMethod != null;
        Method helloMethod = ReflectionUtils.findMethod(HomeService.class, "hello", String.class);
        assert helloMethod != null;

        // 执行方法
        ReflectionUtils.invokeMethod(sayMethod, homeService);

        // 执行方法,提供方法参数
        ReflectionUtils.invokeMethod(helloMethod, homeService, "姓名");

        // 取消 Java 权限检查。以便后续执行该私有方法
        ReflectionUtils.makeAccessible(helloMethod);

        // 取消 Java 权限检查。以便后续执行私有构造方法
        ReflectionUtils.makeAccessible(homeServiceConstructor);
    }

    /**
     * 获取字段
     */
    @Test
    void testD() {
        // 在类查找指定属性
        Field pageField = ReflectionUtils.findField(HomeServiceImpl.class, "page");
        log.info("获得属性: {}", pageField);

        // 同上  多提供了属性的类型
        Field pageField2 = ReflectionUtils.findField(HomeServiceImpl.class, "page", String.class);
        assert pageField2 != null;

        // 是否为一个 public static final 属性
        log.info("是否为一个 public static final 属性: {}", ReflectionUtils.isPublicStaticFinal(pageField2));
    }

    /**
     * 设置字段
     */
    @Test
    void testE() {
        Field pageField = ReflectionUtils.findField(HomeServiceImpl.class, "page");
        assert pageField != null;
        // 修改为非 private 属性
        ReflectionUtils.makeAccessible(pageField);
        // 修改属性值
        ReflectionUtils.setField(pageField, homeService, "page_new.html");
    }
}
