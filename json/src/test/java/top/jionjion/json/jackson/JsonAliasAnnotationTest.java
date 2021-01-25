package top.jionjion.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * .@JsonAlias 类的测试
 *
 * @author Jion
 */
@Slf4j
public class JsonAliasAnnotationTest {

    @Test
    public void test() throws IOException {
        String json = "{\n" +
                "  \"id\":\"1\",\n" +
                "  \"name\": \"囧囧1\",\n" +
                "  \"username\": \"囧囧2\"\n" +
                "}";

        JsonAliasAnnotation student = new ObjectMapper()
                .readerFor(JsonAliasAnnotation.class)
                .readValue(json);

        assertNotNull(student);
        log.info(student.toString());
    }

    @Test
    public void test2() throws IOException {
        JsonAliasAnnotation student = new JsonAliasAnnotation();
        student.setId(1);
        student.setName("囧囧");
        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}
