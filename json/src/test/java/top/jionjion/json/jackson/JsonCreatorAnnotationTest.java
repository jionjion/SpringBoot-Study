package top.jionjion.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * .@JsonCreator 类的测试
 *
 * @author Jion
 */
@Slf4j
class JsonCreatorAnnotationTest {

    @Test
    void test() throws IOException {
        String json = "{\n" +
                "  \"id\":\"1\",\n" +
                "  \"name\": \"囧囧\"\n" +
                "}";

        JsonCreatorAnnotation student = new ObjectMapper()
                .readerFor(JsonCreatorAnnotation.class)
                .readValue(json);

        assertNotNull(student);
        log.info(student.toString());
    }
}
