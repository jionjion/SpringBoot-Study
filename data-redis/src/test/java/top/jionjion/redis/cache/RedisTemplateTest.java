package top.jionjion.redis.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import top.jionjion.redis.DataRedisApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * RedisTemplate的测试
 *
 * @author Jion
 */
@Slf4j
class RedisTemplateTest extends DataRedisApplicationTest {

/*
接口	                    描述,操作对象
GeoOperations               空间地理
HashOperations              Hash 操作
HyperLogLogOperations       HyperLogLog 操作
ListOperations              List 操作
SetOperations               Set 操作
ValueOperations             Value 操作
ZSetOperations              Zset 操作

                            绑定操作
BoundGeoOperations          空间地理
BoundHashOperations         Hash 绑定操作
BoundKeyOperations          Key 绑定操作
BoundListOperations         List 绑定操作
BoundSetOperations          Set 绑定操作
BoundValueOperations        Value 绑定操作
BoundZSetOperations         Zset 绑定操作

 */

    /**
     * Redis操作模板,框架提供
     */
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    /**
     * 字符串操作模板,框架提供
     */
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 测试注入
     */
    @Test
    void testAutowiredBean() {
        assertNotNull(redisTemplate);
        assertNotNull(stringRedisTemplate);
    }

    @Test
    void testRedisTemplateOpsX() {
        //空间地理
        GeoOperations<String, String> geoOperations = redisTemplate.opsForGeo();
        assertNotNull(geoOperations);

        //Hash 操作
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        assertNotNull(hashOperations);

        //HyperLogLog 操作
        HyperLogLogOperations<String, String> hyperLogLogOperations = redisTemplate.opsForHyperLogLog();
        assertNotNull(hyperLogLogOperations);

        //List 操作
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        assertNotNull(listOperations);

        //Set 操作
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        assertNotNull(setOperations);

        //Value 操作
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        assertNotNull(valueOperations);

        //Zset 操作
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        assertNotNull(zSetOperations);

        // 绑定已有的key进行操作

        //空间地理
        BoundGeoOperations<String, String> boundGeoOperations = redisTemplate.boundGeoOps("key");
        assertNotNull(boundGeoOperations);

        //Hash 绑定操作
        BoundHashOperations<String, Object, Object> boundHashOperations = redisTemplate.boundHashOps("key");
        assertNotNull(boundHashOperations);

        //Key 绑定操作
        BoundKeyOperations<String> boundKeyOperations = redisTemplate.boundValueOps("key");
        assertNotNull(boundKeyOperations);

        //List 绑定操作
        BoundListOperations<String, String> boundListOperations = redisTemplate.boundListOps("key");
        assertNotNull(boundListOperations);

        //Set 绑定操作
        BoundSetOperations<String, String> boundSetOperations = redisTemplate.boundSetOps("key");
        assertNotNull(boundSetOperations);

        //Value 绑定操作
        BoundValueOperations<String, String> boundValueOperations = redisTemplate.boundValueOps("key");
        assertNotNull(boundValueOperations);

        //Zset 绑定操作
        BoundZSetOperations<String, String> boundZSetOperations = redisTemplate.boundZSetOps("key");
        assertNotNull(boundZSetOperations);
    }

    /**
     * 开启事物
     */
    @Test
    void testTransactional() {
        redisTemplate.setEnableTransactionSupport(true);
        // 开始事物
        redisTemplate.multi();
        // 提交事物
        redisTemplate.exec();
        // 回归事物
        redisTemplate.discard();
    }


    /**
     * 使用回调进行事物
     */
    @Test
    void testTransactionalWithCallBack() {
        SessionCallback<Object> callback = new SessionCallback<>() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                /* ... */
                return operations.exec();
            }
        };
        redisTemplate.execute(callback);
    }
}