package top.jionjion.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Jion
 * \@JsonDeserialize 注解使用
 */
@Slf4j
public class JsonDeserializeAnnotationTest {

    @Test
    public void test() throws IOException {

        String json = "{\n" +
                "  \"name\": \"囧囧\",\n" +
                "  \"birthday\": \"2019-01-01 12:00:00\"\n" +
                "}";

        JsonDeserializeAnnotation student = new ObjectMapper()
                .readerFor(JsonDeserializeAnnotation.class)
                .readValue(json);

        assertNotNull(student);
        log.info(student.toString());
    }
}