package top.jionjion.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * .@JsonRootName 注解使用
 *
 * @author Jion
 */
@Slf4j
public class JsonRootNameAnnotationTest {

    @Test
    public void test() throws JsonProcessingException {
        JsonRootNameAnnotation student = new JsonRootNameAnnotation();
        student.setId(1);
        student.setName("囧囧");

        String result = new ObjectMapper()
                .enable(SerializationFeature.WRAP_ROOT_VALUE)
                .writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}
