package top.jionjion.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.*;

/**
 * CollectionUtils 集合框架工具包
 *
 * @author Jion
 */
@Slf4j
class CollectionUtilsTest {

    /**
     * 集合判断工具
     */
    @Test
    void testA() {
        Collection<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        // 判断 List/Set 是否为空
        log.info("判断 List/Set 是否为空: {}", CollectionUtils.isEmpty(list));

        // 判断 Map 是否为空
        log.info("判断 Map 是否为空: {}", CollectionUtils.isEmpty(map));

        // 判断 List/Set 中是否包含某个对象
        list.add("A");
        log.info("判断 List/Set 中是否包含对象A: {}", CollectionUtils.containsInstance(list, "A"));

        // 以迭代器的方式,判断 List/Set 中是否包含某个对象
        log.info("以迭代器的方式,判断 List/Set 中是否包含某个对象: {}", CollectionUtils.contains(list.iterator(), "A"));

        // 判断 List/Set 是否包含某些对象中的任意一个
        log.info("判断 List/Set 是否包含某些对象中的任意一个: {}", CollectionUtils.containsAny(list, Collections.singletonList("B")));

        // 判断 List/Set 只含有一个元素.. 即 List/Set 中不存在其他重复元素
        list.add("A");
        log.info("判断 List/Set 中不存在重复元素: {}", CollectionUtils.hasUniqueObject(list));
    }

    /**
     * 集合操作工具
     */
    @Test
    void testB() {
        // 将 Array 中的元素都添加到 List/Set 中
        String[] array = new String[]{"A", "B", "C"};
        List<String> list = new ArrayList<>();
        CollectionUtils.mergeArrayIntoCollection(array, list);
        log.info("将 Array 中的元素都添加到 List/Set 中: {}", list);

        // 返回 List 中最后一个元素
        log.info("返回 List 中最后一个元素: {}", CollectionUtils.lastElement(list));

        // 返回 Set 中最后一个元素
        Set<String> set = Collections.singleton("A");
        log.info("返回 Set 中最后一个元素: {}", CollectionUtils.lastElement(set));

        // 返回参数 candidates 中第一个存在于参数 source 中的元素
        List<String> source = new ArrayList<>();
        source.add("A");
        source.add("B");
        source.add("C");
        Set<String> candidates = Collections.singleton("B");
        log.info("从source集合中查询第一个符合candidates集合的元素: {}", CollectionUtils.findFirstMatch(source, candidates));

        // 返回 List/Set 中指定类型的元素
        List<Object> collection = new ArrayList<>();
        collection.add("A");
        collection.add(new Date());
        collection.add(1);
        collection.add(2);
        log.info("返回指定类型,多个返回空: {}", CollectionUtils.findValueOfType(collection, Integer.class));

        // 返回 List/Set 中指定类型的元素.如果第一种类型未找到,则查找第二种类型,以此类推
        log.info("返回指定类型,如果第一种类型未找到, 则查找第二种类型, 多个返回空: {}", CollectionUtils.findValueOfType(collection, new Class[]{LocalDate.class, String.class}));

        // 返回 List/Set 中元素的类型
        log.info("返回 List/Set 中元素的类型: {}", CollectionUtils.findCommonElementType(set));

        // 将 Properties 中的键值对都添加到 Map 中
        Map<String, String> map = new HashMap<>();
        Properties properties = new Properties(System.getProperties());
        CollectionUtils.mergePropertiesIntoMap(properties, map);
        log.info("将 Properties 中的键值对都添加到 Map 中: {}", map);
    }
}
