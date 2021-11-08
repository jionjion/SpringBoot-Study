package top.jionjion.mybatis.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import top.jionjion.mybatis.mapper.CallMapper;

import java.util.HashMap;
import java.util.Map;

/**
 *  调用存储过程
 * @author Jion
 */
@Slf4j
@SpringBootTest
class CallMapperTest {


    @Autowired
    CallMapper mapper;

    @Test
    void callFunctionOneAddOne(){
        // 参数
        Map<String, Integer> map = new HashMap<>(3);
        map.put("param_a",1);
        map.put("param_b",2);
        // 结果
//        map.put("param_c",null);
        // 执行
        mapper.callFunctionOneAddOne(map);
        // 获得结果
        Integer result = map.get("param_c");
        Assert.notNull(result,"失败");
        log.info(String.valueOf(result));
    }

    @Test
    void callProcedureOneAddOne(){
        // 参数
        Map<String, Integer> map = new HashMap<>(3);
        map.put("param_a",1);
        map.put("param_b",2);
        // 结果
        map.put("result_sum",null);
        // 执行
        mapper.callProcedureOneAddOne(map);
        // 获得结果
        Integer result = map.get("result_sum");
        Assert.notNull(result,"失败");
        log.info(String.valueOf(result));
    }
}