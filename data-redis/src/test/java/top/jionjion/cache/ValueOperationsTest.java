package top.jionjion.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import top.jionjion.DataRedisApplicationTest;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jion
 *  测试 Value
 *      ValueOperations 对 Values 的操作
 */
@Slf4j
public class ValueOperationsTest extends DataRedisApplicationTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    private ValueOperations<String,String> valueOperations;

    @BeforeEach
    public void initOperations(){
        if (Objects.isNull(valueOperations)){
            valueOperations = redisTemplate.opsForValue();
        }
        // 初始化数据,启用事物,并提交
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        redisTemplate.delete("KeyA");
        valueOperations.set("KeyA","Aa");
        valueOperations.set("KeyZero","0");
        redisTemplate.exec();

//        valueOperations.set();
//        valueOperations.setIfAbsent();
//        valueOperations.setIfPresent();
//        valueOperations.get();
//        valueOperations.getAndSet();
//        valueOperations.size();
//        valueOperations.append();
//        valueOperations.increment();
//        valueOperations.decrement();
//        valueOperations.multiSet();
//        valueOperations.multiSetIfAbsent();
//        valueOperations.multiGet();
    }

    /**
     *  语法 SET key value [EX seconds] [PX milliseconds] [NX|XX]
     *  将数据以键值对的形式存入
     *
     *  key为字符型,value格式不限制
     *  例如:set name "jionjion" 将jionjion存入,key为name
     *  [EX seconds]过期时间,单位秒
     *  例如:set name "jionjion" ex 5 将jionjion存入,key为name,且过期时间为5秒
     *  [PX milliseconds]设置过期时间,单位毫秒
     *  例如:set name "jionjion" px 5000 将jionjion存入,key为name,且过期时间为5秒
     *  [NX] 当key不存在时,存入;否则报错.类似新增操作(set if not exists)
     *  例如:set name "jionjion" NX 当name不存在,新增
     *  [XX] 当key存在是,更新;否则不做处理.类似更新操作(set exists)
     *  例如:set name "jionjion" XX 当name存在,更新
     */
    @Test
    public void testSet(){
        // 简单地保存,Key存在则覆盖
        valueOperations.set("KeyA","Aa");
        // 保存并指定过期时间
        valueOperations.set("KeyB","Bb",10, TimeUnit.SECONDS);
        valueOperations.set("KeyC","Cc", Duration.ofMillis(1));
    }

    @Test
    public void testSetIfAbsent(){
        // 保存,当Key不存在时,进行赋值
        Boolean result1 = valueOperations.setIfAbsent("KeyA","Aa");
        assertEquals(false, result1);
        // 保存并指定过期的时间
        Boolean result2 = valueOperations.setIfAbsent("KeyB","Bb",10,TimeUnit.SECONDS);
        assertEquals(true, result2);
        Boolean result3 = valueOperations.setIfAbsent("KeyC","Cc",Duration.ofMillis(1));
        assertEquals(true, result3);
    }


    @Test
    public void testSetIfPresent(){
        // 保存,当Key存在时,进行覆盖更新
        Boolean result1 = valueOperations.setIfPresent("KeyA","Aa");
        assertEquals(true, result1);
        // 保存,当Key存在时,进行覆盖更新,并指定过期的时间
        Boolean result2 = valueOperations.setIfPresent("KeyB","Bb",10,TimeUnit.SECONDS);
        assertEquals(false, result2);
        Boolean result3 = valueOperations.setIfPresent("KeyC","Cc",Duration.ofMillis(1));
        assertEquals(false, result3);
    }

    /**
     *  语法 GET key
     *  通过键,获得以键值对形式存在的值.如果值不存在,则返回nil;另外,键key只能为字符串
     */
    @Test
    public void testGet(){
        String result = valueOperations.get("KeyA");
        assertNotNull(result);
        log.info(result);
    }

    /**
     *  语法 GETSET key value
     *  将key对应的值替换为value,并将替换之前的value返回.如果是新建,则返回nil
     */
    @Test
    public void testGetAndSet(){
        String reuslt = valueOperations.getAndSet("KeyA","Aa1");
        assertEquals("Aa", reuslt);
        log.info(reuslt);
    }

    /**
     *  语法 STRLEN key
     *  获得指定key对应的value的长度,仅限在value类型为字符类型时才有长度,否则返回0
     */
    @Test
    public void testSize(){
        Long result = valueOperations.size("KeyA");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 APPEND key value
     *  如果value存在,则将其拼在原有的值后面,不存在则存入新值.并返回追加后的长度.
     */
    @Test
    public void testAppend(){
        Integer result = valueOperations.append("KeyA","AA");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 SETRANGE key offset value
     *  其中,key为字符类型,offset为非负数,value为字符类型.其目的是将key所对应的值的offset位置以后的内容替换为value所对应的值,类似于截取替换.
     *  当key不存在时,将value写入.
     *  当offset大于字符串的最大长度时,填充\x00
     *  当offset过大时,会消耗过多内容,容易造成阻塞!
     */
    @Test
    public void testSetrange(){
        valueOperations.set("KeyA","Bb",0);
    }

    /**
     *  语法 GETRANGE key start end
     *  其中key为字符类型,start和end类型为数字,正数表示位置从左往右,负数表示从右往左,-1为最后一个字符的位置.start和end的过大或者过小只会返回到极限位置对应的字符串
     */
    @Test
    public void testGetrange(){
        String result = valueOperations.get("KeyA",0,1);
        assertNotNull(result);
        log.info(result);
    }

    /**
     *  语法 INCR key
     *  其中,key对应的值必须为数字类型,表示并将其自增+1.当key不存在时,默认返回1
     *  注意,key对应的值在redis中以数字字符串进行保存!
     */
    @Test
    public void testIncrement(){
        Long result = valueOperations.increment("KeyZero");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 INCRBY key increment
     *  将key对应的值进行自增
     *  其中,key对应的值必须为整数类型,increment为整数,表示将key对应的值其加上increment增量
     */
    @Test
    public void testIncremenByLong(){
        Long result = valueOperations.increment("KeyZero",10L);
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 INCRBYFLOAT key increment
     *  其中,key对应的值必须为数字,但不限制精度.increment为数字类型,不限精度.表示对key对应的相加increment增量.
     *  注意:存储时会自动将尾数抹零.
     */
    @Test
    public void testIncrementByDouble(){
        Double result = valueOperations.increment("KeyZero",100D);
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 DECR key
     *  将key对应的值进行自减.
     */
    @Test
    public void testDecrement(){
        Long result = valueOperations.decrement("KeyZero");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 DECRBY key decrement
     *  其中,key对应的值必须为整数,decrement必须也为整数.表示key对应的值减去decrement增量
     */
    @Test
    public void testDecrementByLong(){
        Long result = valueOperations.decrement("KeyZero",-10L);
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 MSET key value [key value ...]
     *  其中,key为字符类型,value不做限制,表示对一个或者多对键值对进行赋值,如果key重复,则更新对应的value
     */
    @Test
    public void testMultiSet(){
        Map<String,String> keys = new HashMap<>();
        keys.put("KeyA","Aa");
        keys.put("KeyB","Ba");
        keys.put("KeyC","Cc");
        valueOperations.multiSet(keys);
    }

    /**
     *  语法 MSETNX key value [key value ...]
     *  其中,key为字符类型,value不做限制.当key不存在时,执行赋值操作.其中,如果任意一个key存在,则整个赋值操作执行失败.事务回滚
     *  返回1,表示执行成功;返回0,表示执行失败.
     */
    @Test
    public void testMultiSetIfAbsent(){
        Map<String, String> keys = new HashMap<>();
        keys.put("KeyA","Aa");
        keys.put("KeyB","Ba");
        keys.put("KeyC","Cc");
        Boolean result = valueOperations.multiSetIfAbsent(keys);
        assertEquals(false, result);
    }

    /**
     *  语法 MGET key [key …]
     *  其中,key为字符类型.获得一个或者多个key对应的值.不存在返回nil
     */
    @Test
    public void testMultiGet(){
        Set<String> keys = new HashSet<>();
        keys.add("KeyA");
        keys.add("KeyB");
        keys.add("KeyC");
        List<String> results = valueOperations.multiGet(keys);
        assertNotNull(results);
        log.info(results.toString());
    }
}