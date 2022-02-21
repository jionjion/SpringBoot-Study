package top.jionjion.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

/**
 * 测试使用 ObjectUtils
 *
 * @author Jion
 */
@Slf4j
public class ObjectUtilsTest {

    /**
     * 获取对象的基本信息
     */
    @Test
    public void testObjectA() {

        CoreUtilsApplication application = new CoreUtilsApplication();

        // 获取对象的类名 参数为 null 时，返回字符串 "null" 
        log.info("获取对象类名: {}", ObjectUtils.nullSafeClassName(application));

        // 获取对象 HashCode(十进制) 参数为 null 时，返回 0
        log.info("获取对象哈希码: {}", ObjectUtils.nullSafeHashCode(application));

        // 获取对象 HashCode(十六进制) 参数为 null 时，返回 0 
        log.info("获取对象哈希码: {}", ObjectUtils.getIdentityHexString(application));

        // 获取对象的类名和 HashCode 参数为 null 时，返回字符串："" 
        log.info("获取对象地址: {}", ObjectUtils.identityToString(application));

        // 参数为 null 时，返回字符串 "null"
        log.info("获取对象toString结果: {}", ObjectUtils.nullSafeToString(application));

        // 相当于 toString()方法 但参数为 null 时 返回字符串：""
        log.info("获取对象toString结果: {}", ObjectUtils.getDisplayString(application));
    }

    /**
     * 判断工具
     */
    @Test
    public void testObjectB() {
        String[] arrayA = new String[]{"A", "B", "C"};
        // 判断参数对象是否是数组
        log.info("判断对象是否为数组: {}", ObjectUtils.isArray(arrayA));
        // 判断数组是否为空
        log.info("判断数组是否为空: {}", ObjectUtils.isEmpty(arrayA));
        // 判断数组中是否包含指定元素
        log.info("判断数组中是否包含指定元素: {}", ObjectUtils.containsElement(arrayA, "A"));
        // 向参数数组的末尾追加新元素, 并返回一个新数组
        log.info("向参数数组的末尾追加新元素, 并返回一个新数组: {}", Arrays.toString(ObjectUtils.addObjectToArray(arrayA, "D")));

        // 原生基础类型数组 --> 包装类数组
        int[] arrayB = {1, 2, 3};
        log.info("获取原生基础类型数组的包装类数组: {}", Arrays.toString(ObjectUtils.toObjectArray(arrayB)));
    }

    @Test
    public void testObjectC() {
        // 相等，或同为 null时，返回 true
        log.info("判断对象是否相同: {}", ObjectUtils.nullSafeEquals("  ", "")); 
        
        /*
        判断参数对象是否为空，判断标准为：
            Optional: Optional.empty()
               Array: length == 0
        CharSequence: length == 0
          Collection: Collection.isEmpty()
                 Map: Map.isEmpty()
         */
        log.info("判断参数对象是否为空: {}", ObjectUtils.isEmpty(Optional.empty()));
        log.info("判断参数对象是否为空: {}", ObjectUtils.isEmpty(new Arrays[]{}));
        log.info("判断参数对象是否为空: {}", ObjectUtils.isEmpty(Collections.emptyList()));
        log.info("判断参数对象是否为空: {}", ObjectUtils.isEmpty(Collections.emptySet()));
        log.info("判断参数对象是否为空: {}", ObjectUtils.isEmpty(Collections.emptyMap()));
        log.info("判断参数对象是否为空: {}", ObjectUtils.isEmpty(""));
        log.info("判断参数对象是否为空: {}", ObjectUtils.isEmpty(" "));
    }
}
