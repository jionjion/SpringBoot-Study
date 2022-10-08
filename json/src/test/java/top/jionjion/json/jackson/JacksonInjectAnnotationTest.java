package top.jionjion.json.jackson;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * .@JacksonInject 类的测试
 *
 * @author Jion
 */
@Slf4j
class JacksonInjectAnnotationTest {

    @Test
    void test() throws IOException {
        String json = "{\n" +
                "  \"name\": \"囧囧\"\n" +
                "}";
        // 提供的绑定变量
        InjectableValues inject = new InjectableValues.Std().addValue(Integer.class, 1);
        // 变量赋值,并指定读取的类
        JacksonInjectAnnotation student = new ObjectMapper()
                .reader(inject)
                .forType(JacksonInjectAnnotation.class)
                .readValue(json);

        assertNotNull(student);
        log.info(student.toString());
    }
}
