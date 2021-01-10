package top.jionjion.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Jion
 * \@JsonAnySetter 类的测试
 */
@Slf4j
public class JsonAnySetterAnnotationTest {

    @Test
    public void test() throws IOException {
        String json = "{\n" +
                "  \"name\": \"囧囧\",\n" +
                "  \"address\":\"上海\",\n" +
                "  \"age\": \"23\",\n" +
                "  \"score\": {\n" +
                "    \"语文\":\"100\",\n" +
                "    \"数学\": \"99\"\n" +
                "  }\n" +
                "}";

        JsonAnySetterAnnotation student = new ObjectMapper()
                .readerFor(JsonAnySetterAnnotation.class)
                .readValue(json);

        assertNotNull(student);
        log.info(student.toString());
    }
}
