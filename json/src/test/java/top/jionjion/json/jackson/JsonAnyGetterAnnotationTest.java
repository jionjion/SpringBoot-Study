package top.jionjion.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * .@JsonAnyGetter 注解使用
 *
 * @author Jion
 */
@Slf4j
public class JsonAnyGetterAnnotationTest {

    @Test
    public void test() throws JsonProcessingException {
        JsonAnyGetterAnnotation student = new JsonAnyGetterAnnotation();
        student.getInfo().put("姓名", "囧囧");
        student.getInfo().put("学号", "001");
        student.getScore().put("语文", "100");
        student.getScore().put("数学", "99");

        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}
