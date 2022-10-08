package top.jionjion.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * .@JsonIgnore 注解使用
 *
 * @author Jion
 */
@Slf4j
class JsonIgnoreAnnotationTest {

    @Test
    void test() throws JsonProcessingException {
        JsonIgnoreAnnotation student = new JsonIgnoreAnnotation();
        student.setId(1);
        student.setName("囧囧");
        student.setAddress("上海");

        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}
