package top.jionjion.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.connection.RedisZSetCommands.Range;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import top.jionjion.DataRedisApplicationTest;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Jion
 * 测试 ZSet类
 * 操作 集合 ZSet
 */
@Slf4j
public class ZSetOperationsTest extends DataRedisApplicationTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private ZSetOperations<String, String> zSetOperations;

    /**
     * 初始化数据
     */
    @Before
    public void initData() {
        if (Objects.isNull(zSetOperations)) {
            zSetOperations = redisTemplate.opsForZSet();
        }
        // 初始化数据,启用事物,并提交
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        redisTemplate.delete("ZSetA");
        zSetOperations.add("ZSetA","A",1D);
        zSetOperations.add("ZSetA","B",2D);
        zSetOperations.add("ZSetA","C",3D);
        redisTemplate.delete("ZSetB");
        zSetOperations.add("ZSetB","C",1D);
        zSetOperations.add("ZSetB","D",2D);
        zSetOperations.add("ZSetB","E",3D);
        redisTemplate.delete("ZSetZero");
        zSetOperations.add("ZSetZero","0",1D);
        redisTemplate.exec();

//        zSetOperations.add();
//        zSetOperations.score();
//        zSetOperations.incrementScore();
//        zSetOperations.zCard();
//        zSetOperations.count();
//        zSetOperations.range();
//        zSetOperations.rangeWithScores();
//        zSetOperations.reverseRange();
//        zSetOperations.reverseRangeWithScores();
//        zSetOperations.rangeByScore();
//        zSetOperations.rangeByScoreWithScores();
//        zSetOperations.reverseRangeByScore();
//        zSetOperations.reverseRangeByScoreWithScores
//        zSetOperations.rank();
//        zSetOperations.reverseRank();
//        zSetOperations.remove();
//        zSetOperations.removeRange();
//        zSetOperations.removeRangeByScore();
//        zSetOperations.rangeByLex();
//        zSetOperations.scan();
//        zSetOperations.unionAndStore();
//        zSetOperations.incrementScore();

    }

    /**
     * 测试SetOperations是否存在
     */
    @Test
    public void testAutowired() {
        assertNotNull(zSetOperations);
    }

    /**
     *  语法 `ZADD  [NX|XX] [CH] [INCR] score member [score member ...]`
     *  将成员`member`和指定排序顺序`score`放入有序集合`key`中.其中,`score`必须为数字,精度不限,正负不限,越小,排序越靠前.`score`数字相同,则根据字典字母A-Z顺序排序.
     *  如果成员已经存在,则添加失败
     */
    @Test
    public void testAdd(){
        // 添加一个
        Boolean result1 = zSetOperations.add("ZSetA","D",4D);
        assertEquals(true, result1);
        log.info(String.valueOf(result1));

        // 添加一个元组
        ZSetOperations.TypedTuple<String> typedTupleB = new DefaultTypedTuple<>("E",5D);
        ZSetOperations.TypedTuple<String> typedTupleC = new DefaultTypedTuple<>("F",6D);
        Set<ZSetOperations.TypedTuple<String>> tuples = new TreeSet<>();
        tuples.add(typedTupleB);
        tuples.add(typedTupleC);
        Long result = zSetOperations.add("ZsetA",tuples);
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 `ZSCORE key member`
     *  返回成员`member`在有序集合`key`中的顺序.如果`key`不是有序集合,或者`key`不存在,返回`nil`
     */
    @Test
    public void testScore(){
        Double result = zSetOperations.score("ZSetA","A");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 `ZINCRBY key increment member`
     *  为有序集合`key`中的成员`member`的`order`顺序加上增量`increment`.其中,`key`必须为有序集合,`increment`增量可正可负,精度不限.
     *  返回,修改后的成员所在集合的位置
     */
    @Test
    public void testIncrementScore(){
        Double result = zSetOperations.incrementScore("ZSetA","A",1D);
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 `ZCARD key`
     *  返回有序集合`key`的长度.
     */
    @Test
    public void testZCard(){
        Long result = zSetOperations.zCard("ZSetA");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 `ZCOUNT key min max`
     *  获得有序集合`key`中,排序值在`min`和`max`闭区间内的成员数量.`min`和`max`必须为数字,大小不限制.
     */
    @Test
    public void testCount(){
        Long result = zSetOperations.count("ZSetA",0D,10D);
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 `ZRANGE key start stop [WITHSCORES]`
     *  获得有序集合`key`的指定索引区间内的成员.索引从0开始,-1表示最后一个.当`start`和`stop`超出索引边界后,只回返回对应边界的极值所在的值.可选参数`withscores`表示返回对应成员的排序大小.
     *  返回值,按照排序值,从小到大排列.相同排序值成员根据字典顺序排序.
     */
    @Test
    public void testRange(){
        // 全部
        Set<String> result = zSetOperations.range("ZSetA",0,-1);
        assertNotNull(result);
        log.info(result.toString());
    }

    @Test
    public void testRangesWithScore(){
        // 将结果和排序一并返回
        Set<ZSetOperations.TypedTuple<String>> result = zSetOperations.rangeWithScores("ZSetA",0,-1);
        assertNotNull(result);
        log.info(result.toString());
    }


    /**
     *  语法 `ZREVRANGE key start stop [WITHSCORES]`
     *  获得有序集合`key`的指定索引区间内的成员.索引从0开始,-1表示最后一个.
     *  当`start`和`stop`超出索引边界后,只回返回对应边界的极值所在的值.可选参数`withscores`表示返回对应成员的排序大小.
     *  返回值,按照排序值,从大到小排列.相同排序值成员根据字典顺序排序.
     */
    @Test
    public void testReverseRange(){
        // 全部
        Set<String> result = zSetOperations.reverseRange("ZSetA",0,-1);
        assertNotNull(result);
        log.info(result.toString());
    }

    @Test
    public void testReverseRangeWithScores(){
        // 将结果和排序一并返回
        Set<ZSetOperations.TypedTuple<String>> result = zSetOperations.reverseRangeWithScores("ZSetA",0,-1);
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 `ZRANGEBYSCORE key min max [WITHSCORES] [LIMIT offset count]`
     *  获得有序集合`key`中,所有的成员的排序值在`min`和`max`闭区间内的成员.
     *  可以通过`(`,`)`限制区间为开区间.
     *  返回结果根据排序值从小到大排列,相同的成员根据字典顺序排列.
     */
    @Test
    public void testRangeByScore(){
        // 排序值在[0,2]之间的
        Set<String> result1 = zSetOperations.rangeByScore("ZSetA",0,2);
        assertNotNull(result1);
        log.info(result1.toString());

        // 排序值在[0,10]之间,且排序值大于0,最多返回2个
        Set<String> result2 = zSetOperations.rangeByScore("ZSetA",0,10,0,2);
        assertNotNull(result2);
        log.info(result2.toString());
    }

    @Test
    public void testRangeByScoreWithScores(){
        // 排序值在[0,2]之间的
        Set<ZSetOperations.TypedTuple<String>> result1 = zSetOperations.rangeByScoreWithScores("ZSetA",0,2);
        assertNotNull(result1);
        log.info(result1.toString());

        // 排序值在[0,10]之间,且排序值大于0,最多返回2个
        Set<ZSetOperations.TypedTuple<String>> result2 = zSetOperations.rangeByScoreWithScores("ZSetA",0,10,0,2);
        assertNotNull(result2);
        log.info(result2.toString());
    }

    /**
     *  语法 `ZREVRANGEBYSCORE key max min [WITHSCORES] [LIMIT offset count]`
     *  获得有序集合`key`中,所有的成员的排序值在`min`和`max`闭区间内的成员.
     *  可以通过`(`,`)`限制区间为开区间.
     *  返回结果根据排序值从大到大小排列,相同的成员根据字典顺序排列.
     */
    @Test
    public void testReverseRangeByScore(){
        // 排序值在[0,2]之间的
        Set<String> result1 = zSetOperations.reverseRangeByScore("ZSetA",0,2);
        assertNotNull(result1);
        log.info(result1.toString());

        // 排序值在[0,10]之间,且排序值大于0,最多返回2个
        Set<String> result2 = zSetOperations.reverseRangeByScore("ZSetA",0,10,0,2);
        assertNotNull(result2);
        log.info(result2.toString());
    }

    @Test
    public void testReverseRangeByScoreWithScores(){
        // 排序值在[0,2]之间的
        Set<ZSetOperations.TypedTuple<String>> result1 = zSetOperations.reverseRangeByScoreWithScores("ZSetA",0,2);
        assertNotNull(result1);
        log.info(result1.toString());

        // 排序值在[0,10]之间,且排序值大于0,最多返回2个
        Set<ZSetOperations.TypedTuple<String>> result2 = zSetOperations.reverseRangeByScoreWithScores("ZSetA",0,10,0,2);
        assertNotNull(result2);
        log.info(result2.toString());
    }

    /**
     *  语法 `ZRANK key member`
     *  获得有序集合`key`的成员`member`的排名位置.排序规则为排序值从小到大排列.排名从0开始.如果成员`member`不存在,则返回`nil`
     */
    @Test
    public void testRank(){
        Long result = zSetOperations.rank("ZSetA","A");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 `ZREVRANK key member`
     *  获得有序集合`key`的成员`member`的排名位置.排序规则为排序值从大到小排列.排名从0开始.如果成员`member`不存在,则返回`nil`
     */
    @Test
    public void testReverseRank(){
        Long result = zSetOperations.reverseRank("ZSetA","A");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 `ZREM key member [member …]`
     *  移除有序集合`key`中一个或者多个成员`member`,若该成员不存在,则忽略.
     *  返回被移除的成员个数
     */
    @Test
    public void testRemove(){
        Long result = zSetOperations.remove("ZSetA","A","B");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 `ZREMRANGEBYRANK key start stop`
     *  移除有序集合`key`中指定排名`rank`在`start`和`stop`闭区间内的所有成员.`start`从0开始,表示第一个元素;`-1`表示最后一个元素.
     *  返回被移除成员的数量
     */
    @Test
    public void testRemoveRange(){
        // 删除全部
        Long result = zSetOperations.removeRange("ZSetA",0,-1);
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 `ZREMRANGEBYSCORE key min max`
     *  移除有序集合`key`中排序值`score`在`min`和`max`闭区间内的所有成员.
     */
    @Test
    public void testRemoveRangeByScore(){
        Long result = zSetOperations.removeRangeByScore("ZSetA",0D,10D);
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 `ZRANGEBYLEX key min max [LIMIT offset count]`
     *  当有序集合`key`具有相同的排序值`score`时,根据字母的先后顺序进行排列,命令检索`min`字母到`max`字母之间的成员.
     *  必须使用区间限定符,`(`和`)`表示开区间;`[`和`]`表示闭区间;`+`和`-`表示极大值和极小值
     */
    @Test
    public void testRangeByLex(){
        // 实例化对象,并获得限制范围, 比A大的
        Range range = new Range().gt("A");
        Set<String> result1 = zSetOperations.rangeByLex("ZSetA", range);
        assertNotNull(result1);
        log.info(result1.toString());

        // 范围不做限制,返回值中截取第二个,累计截取两个
        RedisZSetCommands.Limit limit = new RedisZSetCommands.Limit();
        limit.offset(1);
        limit.count(2);
        Set<String> result2 = zSetOperations.rangeByLex("ZSetA", Range.unbounded(), limit);
        assertNotNull(result2);
        log.info(result2.toString());
    }

    /*
     *  语法 `ZLEXCOUNT key min max`
     *  当有序集合`key`具有相同的排序值`score`时,根据字母的先后顺序进行排列,命令返回在`min`字母和`max`字母之间的成员总数.
     */
//    @Test
//    public void testZlexcount(){
//        //fail("未提供");
//    }

    /*
     *  语法 `ZREMRANGEBYLEX key min max`
     *  当有序集合`key`具有相同的排序值`score`时,根据字母的先后顺序进行排列,命令移除在`min`字母和`max`字母之间的成员,并返回被移除的成员数量
     */
//    @Test
//    public void testZremrangebylex(){
//        //fail("未提供");
//    }

    @Test
    public void testScan(){
        fail("未验证");
    }

    /**
     *  语法 `ZUNIONSTORE destination numkeys key [key ...] [WEIGHTS weight [weight ...]] [AGGREGATE SUM|MIN|MAX]`
     *  集合并集并保存
     *  返回新集合的长度
     */
    @Test
    public void testUnionAndStore(){
        Long result = zSetOperations.unionAndStore("ZSetA","ZSetB","ZsetC");
        assertNotNull(result);
        log.info(result.toString());
    }

    /**
     *  语法 `ZINTERSTORE destination numkeys key [key ...] [WEIGHTS weight [weight ...]] [AGGREGATE SUM|MIN|MAX]`
     *  集合交集并保存
     *  返回新集合的长度
     */
    @Test
    public void testIntersectAndStore(){
        Long result = zSetOperations.intersectAndStore("ZSetA","ZSetB","ZsetC");
        assertNotNull(result);
        log.info(result.toString());
    }

}
