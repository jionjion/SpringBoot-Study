package top.jionjion.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * .@JsonUnwrapped 注解使用
 *
 * @author Jion
 */
@Slf4j
public class JsonUnwrappedAnnotationTest {

    @Test
    public void test() throws JsonProcessingException {
        JsonUnwrappedAnnotation.Student student = new JsonUnwrappedAnnotation.Student();
        student.setId(1);
        student.setName("囧囧");
        JsonUnwrappedAnnotation.Info info = new JsonUnwrappedAnnotation.Info("上海", "00001");
        student.setInfo(info);

        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}
