package top.jionjion.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * .@JsonView 注解使用
 *
 * @author Jion
 */
@Slf4j
class JsonViewAnnotationTest {

    @Test
    void test() throws JsonProcessingException {
        JsonViewAnnotation student = new JsonViewAnnotation();
        student.setId(1);
        student.setName("囧囧");

        String result = new ObjectMapper()
                .writerWithView(Views.Show.class)
                .writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}