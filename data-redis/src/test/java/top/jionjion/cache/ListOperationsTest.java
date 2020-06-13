package top.jionjion.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import top.jionjion.DataRedisApplicationTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;

/**
 * @author Jion
 *  测试 List
 *      ListOperations 对List的操作
 */
@Slf4j
public class ListOperationsTest extends DataRedisApplicationTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private ListOperations<String,String> listOperations;

    @Before
    public void initOperations(){
        if (Objects.isNull(listOperations)){
            listOperations = redisTemplate.opsForList();
        }
        // 初始化数据,启用事物,并提交
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        redisTemplate.delete("ListA");
        listOperations.rightPush("ListA","A");
        listOperations.rightPush ("ListA","B");
        listOperations.rightPush ("ListA","C");
        redisTemplate.delete("ListB");
        listOperations.rightPush ("ListB","D");
        listOperations.rightPush ("ListB","E");
        listOperations.rightPush ("ListB","F");
        redisTemplate.exec();


//        listOperations.leftPush();
//        listOperations.leftPushAll();
//        listOperations.leftPushIfPresent()
//        listOperations.rightPush();
//        listOperations.rightPushAll();
//        listOperations.rightPushIfPresent();
//        listOperations.leftPop();
//        listOperations.rightPop();
//        listOperations.rightPopAndLeftPush();
//        listOperations.remove();
//        listOperations.size();
//        listOperations.index();
//        listOperations.set();
//        listOperations.range();
//        listOperations.trim();

    }

    /**
     *  语法 `LPUSH key value [value ...]
     *  将一个或者多个`value`值顺次插入到列表`key`的头前.`key`必须为列表类型,否则报错;如果`key`列表不存在,则自动创建.`key`列表的顺序由插入时的顺序决定,并且允许重复插入.
     */

    @Test
    public void testLeftPush(){
        Long result = listOperations.leftPush("ListA","D");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 `LPUSH key value [value ...]
     *  将一个或者多个`value`值顺次插入到列表`key`的头前.`key`必须为列表类型,否则报错;如果`key`列表不存在,则自动创建.`key`列表的顺序由插入时的顺序决定,并且允许重复插入.
     */
    @Test
    public void testLeftPushAll(){
        // 添加多个
        Long result1 = listOperations.leftPushAll("ListA","A","B","C");
        assertNotNull(result1);
        log.info(result1.toString());

        // 通过List添加
        List<String> values = new ArrayList<>();
        values.add("A");
        values.add("B");
        values.add("C");
        Long result2 = listOperations.leftPushAll("ListA",values);
        assertNotNull(result2);
        log.info(result2.toString());
    }

    /**
     *  语法 LPUSHX key value [value ...]
     *  将一个或者多个value值顺次插入到列表key的头前.key必须存在且为列表类型,否则不做任何处理.
     */
    @Test
    public void testLeftPushIfPresent(){
        // ListA 必须存在
        Long result = listOperations.leftPushIfPresent("ListA","A");
        assertNotNull(result);
        log.info(result.toString());
    }


    /**
     *  语法 RPUSH key value [value ...]
     *  将一个或者多个value值顺次追加到列表尾.key必须为列表类型,否则报错.如果key列表不存在,则自动创建.
     */
    @Test
    public void testRightPush(){
        Long result = listOperations.rightPush("ListA","A");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 RPUSH key value [value ...]
     *  将一个或者多个value值顺次追加到列表尾.key必须为列表类型,否则报错.如果key列表不存在,则自动创建.
     */
    @Test
    public void testRightPushAll(){
        // 添加多个
        Long result1 = listOperations.rightPushAll("ListA","A","B","C");
        assertNotNull(result1);
        log.info(result1.toString());

        // 通过List添加
        List<String> values = new ArrayList<>();
        values.add("A");
        values.add("B");
        values.add("C");
        Long result2 = listOperations.rightPushAll("ListA",values);
        assertNotNull(result2);
        log.info(result2.toString());
    }

    /**
     *  语法 RPUSHX key value [value ...]
     *  将一个或者多个value值顺次追加到列表为,key必须存在且为列表类型,否则不做任何修改.
     */
    @Test
    public void testRightPushIfPresent(){
        Long result = listOperations.rightPush("ListA","A");
        assertNotNull(result);
        log.info(result.toString());
    }


    /**
     *  语法 LPOP key
     *  将列表头元素删除,并返回.key不存在或者列表为空时,返回nil.
     */
    @Test
    public void testLeftPop(){
        String result = listOperations.leftPop("ListA");
        assertNotNull(result);
        log.info(result);
    }

    /**
     *  语法 RPOP key
     *  将列表尾元素删除,并返回.key不存在或者列表为空时,返回nil.
     */
    @Test
    public void testRightPop(){
        String result = listOperations.rightPop("ListA");
        assertNotNull(result);
        log.info(result);
    }

    /**
     *  语法 RPOPLPUSH source destination
     *  source和destination必须列表类型,命令将source列表的最后一个元素弹出,并返回给客户端.同时,将弹出的元素重新插入到destination列表的第一个位置.
     *  source列表如果不存在,则不进行动作.
     *  destination列表如果不存在,则创建.
     *  source和destination可以为同一个列表,此时命令等同于rotation旋转操作.
     *  整体操作具有原子性,列表修改同时成功或者同时失败.
     */
    @Test
    public void testRightPopAndLeftPush(){
        String result = listOperations.rightPopAndLeftPush("ListA","ListB");
        assertNotNull(result);
        log.info(result);
    }

    /**
     *  语法 LREM key count value
     *  key必须为列表,count必须为整数,其绝对值表示将要从key列表中移除的value的个数,当count为正整数时,表示从左往右移除指定count个与value相同的元素;count为负数时,移除顺序相反;count为0,表示移除全部
     */
    @Test
    public void testRemove(){
        Long result = listOperations.remove("ListA",1L,"A");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 LLEN key
     *  返回类表的长度,如果列表不存在,或者为空列表,则返回0
     */
    @Test
    public void testSize(){
        Long result = listOperations.size("ListA");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 LINDEX key index
     *  返回列表key中,索引位置为index的元素.其中,key必须为列表类型,index为必须为整数,正整数表示索引从前往后,0为列表第一个元素;负整数表示索引从后往前,-1为列表最后一个元素.如果索引超过列表长度,返回nil.
     */
    @Test
    public void testIndex(){
        String result1 = listOperations.index("ListA",0);
        assertNotNull(result1);
        log.info(result1);

        String result2 = listOperations.index("ListB",-1);
        assertNotNull(result2);
        log.info(result2);
    }

    /**
     *  语法 LSET key index value
     *  将列表key的索引位置为index的元素的值替换为value.
     *  越界抛出异常
     */
    @Test
    public void testSet(){
         listOperations.set("ListA",2,"D");
    }

    /**
     *  语法 LRANGE key start stop
     *  返回列表key中,从start到stop区间内的元素,索引从0开始,表示第一个元素;-1表示最后一个元素.start或stop过小或者过大均自动截取列表的极值
     */
    @Test
    public void testRange(){
        List<String> result = listOperations.range("ListA",0,-1);
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 LTRIM key start stop
     *  对列表key进行修剪,只保留start和stop的区间内的元素.start和stop超过列表长度,返回错误.
     */
    @Test
    public void testTrim(){
        listOperations.trim("ListA",0,1);
    }

    /**
     *  语法 BLPOP key [key ...] timeout
     *  阻塞式弹出列表key的列首第一个元素,如过列表为空,等待timeout秒,如果timeout设置为0,表示一直等待到列表具有元素时才进行弹出.
     *  当有多个key时,会根据key的先后顺序,检测每一个列表,直到有一个能弹出列首元素为止.
     *  返回,被弹出的列表名称和弹出的元素
     */
    @Test
    public void testLeftPopB(){
        String result = listOperations.leftPop("ListA",10, TimeUnit.SECONDS);
        assertNotNull(result);
        log.info(result);
    }

    /**
     *  语法 BRPOP key [key ...] timeout
     *  阻塞式弹出列表key的列尾最后一个元素,如过列表为空,等待timeout秒,如果timeout设置为0,表示一直等待到列表具有元素时才进行弹出.
     *  当有多个key时,会根据key的先后顺序,检测每一个列表,直到有一个能弹出列尾元素为止.
     *  返回,被弹出的列表名称和弹出的元素
     */
    @Test
    public void testRightPopB(){
        String result = listOperations.rightPop("ListA",10, TimeUnit.SECONDS);
        assertNotNull(result);
        log.info(result);
    }

    /**
     *  语法 BRPOPLPUSH source destination timeout
     *  将source列表的列尾元素弹出,并插入destination列表的列首,如果source列表为空,则等待timeout秒,timeout为0,则持续等待.
     *  source和destination可以为同一个列表.
     */
    @Test
    public void testRightPopAndLeftPushB(){
        String result = listOperations.rightPopAndLeftPush("ListA","ListA",10,TimeUnit.SECONDS);
        assertNotNull(result);
        log.info(result);
    }
}
