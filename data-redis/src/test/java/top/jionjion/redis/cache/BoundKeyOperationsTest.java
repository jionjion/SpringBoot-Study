package top.jionjion.redis.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.BoundKeyOperations;
import org.springframework.data.redis.core.RedisTemplate;
import top.jionjion.redis.DataRedisApplicationTest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jion
 *  测试 BoundKeyOperations 接口
 *      实现类
 *          BoundGeoOperations          空间地理
 *          BoundHashOperations         Hash 绑定操作
 *          BoundKeyOperations          Key 绑定操作
 *          BoundListOperations         List 绑定操作
 *          BoundSetOperations          Set 绑定操作
 *          BoundValueOperations        Value 绑定操作
 *          BoundZSetOperations         Zset 绑定操作
 *
 */
@Slf4j
public class BoundKeyOperationsTest extends DataRedisApplicationTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private BoundKeyOperations<String> boundKeyOperations;

    @BeforeEach
    public void initOperations(){
        if (Objects.isNull(boundKeyOperations)){
            // 创建Key,不存在则创建
            boundKeyOperations = redisTemplate.boundSetOps("KeyA");
        }
    }


    /**
     *  获得 Key
     */
    @Test
    public void testGetKey(){
        String result = boundKeyOperations.getKey();
        log.info(result);
        assertNotNull(result);
    }

    /**
     *  获得对应的数据类型
     */
    @Test
    public void testGetType(){
        DataType dataType = boundKeyOperations.getType();
        assertEquals(dataType,DataType.SET);

        String code = dataType != null ? dataType.code() : null;
        log.info(code);
        assertNotNull(code);

        String name = dataType.name();
        log.info(name);
        assertNotNull(name);
    }

    /**
     *  获得过期时间,单位 S 秒
     *  如果为 -1,表示永久不过期
     */
    @Test
    public void testGetExpire(){
        Long result = boundKeyOperations.getExpire();
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  设置过期时间,指定时间和单位
     */
    @Test
    public void testExpire(){
        Boolean result = boundKeyOperations.expire(1000, TimeUnit.HOURS);
        assertEquals(true, result);
    }

    /**
     *  设定在什么时候过期
     */
    @Test
    public void testExpireAt(){
        Date date = new GregorianCalendar(2020, Calendar.JULY, 11).getTime();
        Boolean result = boundKeyOperations.expireAt(date);
        assertEquals(true, result);
    }

    /**
     *  清除过期时间,永久保存
     */
    @Test
    public void testPersist(){
        Boolean result = boundKeyOperations.persist();
        assertEquals(true, result);
    }

    /**
     *  重命名Key,如果之前存在则覆盖
     */
    @Test
    public void testRename(){
         boundKeyOperations.rename("KeyB");
    }
}
