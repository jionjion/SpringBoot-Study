package top.jionjion.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * .@JsonFilter 注解使用
 *
 * @author Jion
 */
@Slf4j
public class JsonFilterAnnotationTest {

    @Test
    public void test() throws JsonProcessingException {
        JsonFilterAnnotation student = new JsonFilterAnnotation();
        student.setId(1);
        student.setName("囧囧");

        // 过滤器
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("jsonFilter", // 过滤器名称
                        SimpleBeanPropertyFilter.filterOutAllExcept("name") // 仅允许输出的类
                );

        // 输出
        String result = new ObjectMapper()
                .writer(filters)
                .writeValueAsString(student);

        assertNotNull(result);
        log.info(result);
    }
}