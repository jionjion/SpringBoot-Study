package top.jionjion.redis.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import top.jionjion.redis.DataRedisApplicationTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试 Hash
 * HashOperations 对Hash的操作
 *
 * @author Jion
 */
@Slf4j
@SuppressWarnings("SpellCheckingInspection")
class HashOperationsTest extends DataRedisApplicationTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private HashOperations<String, String, String> hashOperations;

    @BeforeEach
    public void initOperations() {
        if (Objects.isNull(hashOperations)) {
            hashOperations = redisTemplate.opsForHash();
        }
        // 初始化数据,启用事物,并提交
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        redisTemplate.delete("HashA");
        hashOperations.put("HashA", "zero", "0");
        hashOperations.put("HashA", "a", "Aa");
        hashOperations.put("HashA", "b", "Bb");
        hashOperations.put("HashA", "c", "Cc");
        redisTemplate.exec();
    }

    /**
     * 语法 HSET hash field value
     * 其中,hash为字符类型,代表哈希表的名字,field为域,同为字符类型,value为域中存放的值,类型不限
     * 当不存这个hash或者field时,则自动创建;field重复时,则更新value.
     */
    @Test
    void testPut() {
        hashOperations.put("HashA", "d", "Dd");
    }

    /**
     * 语法 HMSET key field value [field value ...]
     * 为key哈希表中,创建多个field域并赋值.如果field域已经存在,则覆盖值;如果field域不存在,则创建并赋值
     */
    @Test
    void testPutAll() {
        Map<String, String> map = new HashMap<>();
        map.put("d", "Dd");
        map.put("e", "Ee");
        hashOperations.putAll("HashA", map);
    }

    /**
     * 语法 HGET hash field
     * 其中,hash为字符类型,为已存在的哈希表,field字符类型,哈希表对应的域.命令为获得指定哈希表中的字段的值.
     */
    @Test
    void testGet() {
        String result = hashOperations.get("HashA", "a");
        assertNotNull(result);
        log.info(result);
    }

    /**
     * 语法 HEXISTS hash field
     * 检查hash哈希表中是否含有field域.其中,hash字符类型,哈希表的名字.field字符类型.
     */
    @Test
    void testHasKey() {
        Boolean result = hashOperations.hasKey("HashA", "a");
        assertTrue(result);
        log.info(result.toString());
    }

    /**
     * 语法 HDEL key field [field ...]
     * 删除key对应哈希表的一个或者多个field域.key字符类型,field字符类型
     * 如果field域不存在,不影响
     */
    @Test
    void testDelete() {
        Long result = hashOperations.delete("HashA", "a", "b");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     * 语法 HLEN key
     * 获得当前哈希表中的域值数量.
     */
    @Test
    void testSize() {
        Long result = hashOperations.size("HashA");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     * 语法 HSTRLEN key field
     * 获得key哈希表中field域的字符串的值的长度.
     */
    @Test
    void testLengthOfValue() {
        Long result = hashOperations.lengthOfValue("HashA", "a");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     * 语法 HINCRBY key field increment
     * 为key哈希表中的field域的值加上增量increment,其中field对应的值必须为整数,不限正负,若不存在则创建,increment也必须为整数,正数为加上增量,负数为减去增量
     */
    @Test
    void testIncrementLong() {
        Long result = hashOperations.increment("HashA", "zero", 100L);
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     * 语法 HINCRBYFLOAT key field increment
     * 为key哈希表中的field域加上增量increment,其中field对应的值必须为数字,不限制正负数.increment也必须为数字.程序会为运算后的结果自动抹去尾零,并以数字字符串的形式存入.
     */
    @Test
    void testIncrementDouble() {
        Double result = hashOperations.increment("HashA", "zero", 3.1415926D);
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     * 语法 HMSET key field value [field value ...]
     * 为key哈希表中,创建多个field域并赋值.如果field域已经存在,则覆盖值;如果field域不存在,则创建并赋值
     */
    @Test
    void testPutIfAbsent() {
        Boolean result = hashOperations.putIfAbsent("HashA", "d", "Dd");
        log.info(result.toString());
        assertTrue(result);
    }

    /**
     * 语法 HMGET key field [field ...]
     * 获得key哈希表中的多个field的值.如果field值不存在,则返回nil.
     */
    @Test
    void testMultiGet() {
        Set<String> hashKeys = new HashSet<>();
        hashKeys.add("a");
        hashKeys.add("b");
        List<String> result = hashOperations.multiGet("HashA", hashKeys);
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     * 语法 HKEYS key
     * 获得key哈希表中所有的field的信息.key不存在时,返回空集合.
     */
    @Test
    void testKeys() {
        Set<String> hashKeys = hashOperations.keys("HashA");
        assertNotNull(hashKeys);
        log.info(hashKeys.toString());
    }

    /**
     * 语法 HVALS key
     * 获得key哈希表中的所有域的值.key不存在时,返回空集合.
     */
    @Test
    void testValues() {
        List<String> hashValues = hashOperations.values("HashA");
        assertNotNull(hashValues);
        log.info(hashValues.toString());
    }

    /**
     * 语法 HVALS key
     * 获得key哈希表中的所有域的值.key不存在时,返回空集合.
     */
    @Test
    void testEntries() {
        Map<String, String> entries = hashOperations.entries("HashA");
        assertNotNull(entries);
        log.info(entries.toString());
    }

    @Test
    void testScan() {
        fail("暂未处理...");
    }
}
