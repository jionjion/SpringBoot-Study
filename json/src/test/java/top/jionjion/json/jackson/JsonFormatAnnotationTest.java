package top.jionjion.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * .@JsonFormat 注解使用
 *
 * @author Jion
 */
@Slf4j
class JsonFormatAnnotationTest {

    @Test
    void test() throws JsonProcessingException {
        JsonFormatAnnotation student = new JsonFormatAnnotation();
        student.setName("囧囧");
        student.setBirthday(new Date());

        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}