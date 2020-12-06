package top.jionjion.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import top.jionjion.DataRedisApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jion
 *  RedisTemplate的测试
 */
@Slf4j
public class RedisTemplateTest extends DataRedisApplicationTest {

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

    /** Redis操作模板,框架提供 */
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    /** 字符串操作模板,框架提供 */
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /** 测试注入 */
    @Test
    public void testAutowiredBean(){
        assertNotNull(redisTemplate);
        assertNotNull(stringRedisTemplate);
    }

    @Test
    public void testRedisTemplateOpsX(){
        //空间地理
        GeoOperations  geoOperations = redisTemplate.opsForGeo();
        assertNotNull(geoOperations);

        //Hash 操作
        HashOperations hashOperations = redisTemplate.opsForHash();
        assertNotNull(hashOperations);

        //HyperLogLog 操作
        HyperLogLogOperations hyperLogLogOperations = redisTemplate.opsForHyperLogLog();
        assertNotNull(hyperLogLogOperations);

        //List 操作
        ListOperations listOperations = redisTemplate.opsForList();
        assertNotNull(listOperations);

        //Set 操作
        SetOperations setOperations = redisTemplate.opsForSet();
        assertNotNull(setOperations);

        //Value 操作
        ValueOperations valueOperations = redisTemplate.opsForValue();
        assertNotNull(valueOperations);

        //Zset 操作
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        assertNotNull(zSetOperations);

        // 绑定已有的key进行操作

        //空间地理
        BoundGeoOperations boundGeoOperations = redisTemplate.boundGeoOps("key");
        assertNotNull(boundGeoOperations);

        //Hash 绑定操作
        BoundHashOperations boundHashOperations = redisTemplate.boundHashOps("key");
        assertNotNull(boundHashOperations);

        //Key 绑定操作
        BoundKeyOperations boundKeyOperations = redisTemplate.boundValueOps("key");
        assertNotNull(boundKeyOperations);

        //List 绑定操作
        BoundListOperations boundListOperations = redisTemplate.boundListOps("key");
        assertNotNull(boundListOperations);

        //Set 绑定操作
        BoundSetOperations boundSetOperations = redisTemplate.boundSetOps("key");
        assertNotNull(boundSetOperations);

        //Value 绑定操作
        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps("key");
        assertNotNull(boundValueOperations);

        //Zset 绑定操作
        BoundZSetOperations boundZSetOperations = redisTemplate.boundZSetOps("key");
        assertNotNull(boundZSetOperations);
    }

    /** 开启事物 */
    @Test
    public void testTransactional(){
        redisTemplate.setEnableTransactionSupport(true);
        // 开始事物
        redisTemplate.multi();
        // 提交事物
        redisTemplate.exec();
        // 回归事物
        redisTemplate.discard();
    }


    /** 使用回调进行事物 */
    @Test
    public void testTransactionalWithCallBack() {
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