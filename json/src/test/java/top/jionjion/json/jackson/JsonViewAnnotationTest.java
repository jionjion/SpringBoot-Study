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
public class JsonViewAnnotationTest {

    @Test
    public void test() throws JsonProcessingException {
        JsonViewAnnotation student = new JsonViewAnnotation();
        student.setId(1);
        student.setName("囧囧");

        String result = new ObjectMapper()
                .writerWithView(Views.show.class)
                .writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}