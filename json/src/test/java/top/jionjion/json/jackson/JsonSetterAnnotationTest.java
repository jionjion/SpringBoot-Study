package top.jionjion.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * .@JsonSetter 类的测试
 *
 * @author Jion
 */
@Slf4j
public class JsonSetterAnnotationTest {

    @Test
    public void test() throws IOException {
        String json = "{\n" +
                "  \"id\":\"1\",\n" +
                "  \"name\": \"囧囧\"\n" +
                "}";

        JsonSetterAnnotation student = new ObjectMapper()
                .readerFor(JsonSetterAnnotation.class)
                .readValue(json);

        assertNotNull(student);
        log.info(student.toString());
    }
}
