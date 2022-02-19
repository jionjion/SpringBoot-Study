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
public class ReflectionUtilsTest {

    @Autowired
    HomeService homeService;

    /**
     * 获取方法
     */
    @Test
    public void testA() throws NoSuchMethodException {
        // 在类中查找指定方法
        ReflectionUtils.findMethod(HomeService.class, "hello");

        // 同上  额外提供方法参数类型作查找条件
        ReflectionUtils.findMethod(HomeService.class, "hello", String.class);

        // 获得类中所有方法  包括继承而来的
        ReflectionUtils.getAllDeclaredMethods(HomeService.class);

        // 在类中查找指定构造方法
        Constructor constructor = ReflectionUtils.accessibleConstructor(HomeServiceImpl.class);


        // 是否是 equals() 方法
        boolean isEqualsMethod (Method method)
        // 是否是 hashCode() 方法
        boolean isHashCodeMethod (Method method)
        // 是否是 toString() 方法
        boolean isToStringMethod (Method method)
        // 是否是从 Object 类继承而来的方法
        boolean isObjectMethod (Method method)
        // 检查一个方法是否声明抛出指定异常
        boolean declaresException (Method method, Class < ?>exceptionType)
    }

    /**
     * 执行方法
     */
    public void testB() {
        // 执行方法
        Object invokeMethod (Method method, Object target)
        // 同上  提供方法参数
        Object invokeMethod (Method method, Object target, Object...args)
        // 取消 Java 权限检查。以便后续执行该私有方法
        void makeAccessible (Method method)
        // 取消 Java 权限检查。以便后续执行私有构造方法
        void makeAccessible (Constructor < ? > ctor)
    }

    /**
     * 获取字段
     */
    public void testC() {

        // 在类查找指定属性
        Field findField (Class < ? > clazz, String name)
        // 同上  多提供了属性的类型
        Field findField (Class < ? > clazz, String name, Class < ?>type)
        // 是否为一个 "public static final" 属性
        boolean isPublicStaticFinal (Field field)
    }

    /**
     * 设置字段
     */
    public void testD() {

    }
}
