package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Jion
 * \@JsonAutoDetect 注解使用
 */
@Slf4j
public class JsonAutoDetectTest {

    /**
     * 内部类
     */
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public class Student {

        private Integer id;
        private String name;

        public Student(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Test
    public void test() throws JsonProcessingException {
        Student student = new Student(1,"囧囧");

        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}
