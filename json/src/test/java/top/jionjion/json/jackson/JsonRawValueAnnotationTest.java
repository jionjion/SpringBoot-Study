package top.jionjion.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * .@JsonRawValue 注解使用
 *
 * @author Jion
 */
@Slf4j
public class JsonRawValueAnnotationTest {

    @Test
    public void test() throws JsonProcessingException {
        JsonRawValueAnnotation student = new JsonRawValueAnnotation();
        student.setName("囧囧");
        // JSON字符串
        student.setInfo("{\"地址\":\"上海\",\"年龄\":\"23\"}");

        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}
