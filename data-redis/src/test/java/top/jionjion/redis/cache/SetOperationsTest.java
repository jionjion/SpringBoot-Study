package top.jionjion.redis.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import top.jionjion.redis.DataRedisApplicationTest;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jion
 * 测试Set类
 *  SetOperations 对 Set 的操作
 */
@Slf4j
public class SetOperationsTest extends DataRedisApplicationTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private SetOperations<String, String> setOperations;

    /**
     * 初始化数据
     */
    @BeforeEach
    public void initData() {
        if (Objects.isNull(setOperations)) {
            setOperations = redisTemplate.opsForSet();
        }
        // 初始化数据,启用事物,并提交
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        redisTemplate.delete("SetA");
        redisTemplate.delete("SetB");
        redisTemplate.delete("SetC");
        setOperations.add("SetA","A","B","C");
        setOperations.add("SetB","C","D","E");
        redisTemplate.exec();
    }

    /**
     * 测试SetOperations是否存在
     */
    @Test
    public void testAutowired() {
        assertNotNull(setOperations);
    }


    /**
     * 语法 SADD key member [member ...]
     * 添加
     */
    @Test
    public void testAdd() {
        Long result1 = setOperations.add("SetA", "D");
        log.info(String.valueOf(result1));
        assertNotNull(result1);
        Long result2 = setOperations.add("SetA", "E", "F");
        log.info(String.valueOf(result2));
        assertNotNull(result2);
    }

    /**
     * 语法 SISMEMBER key member
     * 判断集合是否存在某元素
     */
    @Test
    public void testIsMember() {
        Boolean result = setOperations.isMember("SetA", "C");
        log.info(String.valueOf(result));
        assertEquals(true, result);
    }

    /**
     * 语法 SPOP key [count]
     * 从集合key中随机移除count个成员,并返回.当集合不存在时,返回nil.
     */
    @Test
    public void testPop() {
        String result1 = setOperations.pop("SetA");
        log.info(result1);
        assertNotNull(result1);

        List<String> result2 = setOperations.pop("SetA", 2);
        log.info(String.valueOf(result2));
        if (result2 != null) {
            assertNotEquals(0, result2.size());
        }
    }

    /**
     *  语法 SRANDMEMBER key [count]
     *  从集合key中随机获得指定个数的成员.若集合为空,则返回nil
     */
    @Test
    public void testRandomMember() {
        String result1 = setOperations.randomMember("SetA");
        log.info(result1);
        assertNotNull(result1);
        // List 可重复
        List<String> result2 = setOperations.randomMembers("SetA",2);
        if (result2 != null) {
            assertNotEquals(0,result2.size());
        }
        log.info(String.valueOf(result2));
    }

    /**
     *  语法 SRANDMEMBER key [count]
     *  从集合key中随机获得数量值的成员,如果一个值多次出现则只出现一次,若集合为空,则返回nil
     */
    @Test
    public void testDistinctRandomMembers() {
        // Set,不重复
        Set<String> result = setOperations.distinctRandomMembers("SetA",2);
        assertNotEquals(0, result != null ? result.size() : 0);
        log.info(String.valueOf(result));
    }


    /**
     *  语法 SREM key member [member …]
     *  移除集合key中的一个或者多个成员,不存在的member则忽略.
     */
    @Test
    public void testRemove() {
        Long result = setOperations.remove("SetA","A","B");
        log.info(String.valueOf(result));
        assertNotNull(result);
    }

    /**
     *  语法 SMOVE source destination member
     *  将member成员从source集合删除,并添加到destination集合中.两个集合必须存在.
     */
    @Test
    public void testMove() {
        Boolean result = setOperations.move("SetA","A","SetB");
        log.info(String.valueOf(result));
        assertEquals(true, result);
    }

    /**
     *  语法 SCARD key
     *  获得集合key中的成员数量.如果集合不存在或者为空,返回0
     */
    @Test
    public void testSize() {
        Long result = setOperations.size("SetA");
        log.info(String.valueOf(result));
        assertNotNull(result);
    }

    /**
     *  语法 SMEMBERS key
     *  获得集合中的所有成员,key或者为空,返回错误
     */
    @Test
    public void testMembers() {
         Set<String> result = setOperations.members("SetA");
         log.info(String.valueOf(result));
         assertNotNull(result);
    }

    @Test
    public void testScan() {
        fail("未测试...");
    }

    /**
     *  语法 SINTERSTORE destination key [key ...]
     *  获得多个key集合之间的交集,并将结果赋值给集合destination.如果集合destination存在,则覆盖.
     */
    @Test
    public void testIntersect() {
        Set<String> result = setOperations.intersect("SetA","SetB");
        log.info(String.valueOf(result));
        assertNotNull(result);
    }

    /**
     *  语法 SINTERSTORE destination key [key ...]
     *  获得多个key集合之间的交集,并将结果赋值给集合destination.如果集合destination存在,则覆盖.
     */
    @Test
    public void testIntersectAndStore() {
       Long result = setOperations.intersectAndStore("SetA","SetB","SetC");
       log.info(String.valueOf(result));
       assertNotNull(result);
       assertNotNull(setOperations.size("SetC"));
    }

    /**
     *  语法 SUNION destination key [key ...]
     *  获得多个key集合共同的并集,并返回集合对象
     */
    @Test
    public void testUnion() {
        Set<String> result = setOperations.union("SetA","SetB");
        log.info(String.valueOf(result));
        assertNotNull(result);
    }

    /**
     *  语法 SINTERSTORE destination key [key ...]
     *  获得多个key集合之间的交集,并将结果赋值给集合destination.如果集合destination存在,则覆盖.
     */
    @Test
    public void testUnionAndStore() {
        Long result = setOperations.unionAndStore("SetA","SetB","SetC");
        log.info(String.valueOf(result));
        assertNotNull(result);
        assertNotNull(setOperations.size("SetC"));
    }

    /**
     *  语法 SDIFF key [key ...]
     *  获得key集合之间的差集,根据key的顺序依次相减,并返回差集成员.
     */
    @Test
    public void testDifference() {
        Set<String> result = setOperations.difference("SetA","SetB");
        log.info(String.valueOf(result));
        assertNotNull(result);
    }

    /**
     *  语法 SDIFFSTORE destination key [key ...]
     *  获得多个key集合的差集,根据key的顺序相减,并赋值给destination.如果集合destination存在,则覆盖.
     */
    @Test
    public void testDifferenceAndStore() {
        Long result = setOperations.differenceAndStore("SetA","SetB","SetC");
        log.info(String.valueOf(result));
        assertNotNull(result);
        assertNotNull(setOperations.size("SetC"));
    }
}