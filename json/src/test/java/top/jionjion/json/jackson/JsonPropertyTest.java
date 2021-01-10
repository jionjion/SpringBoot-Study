package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Jion
 * \@JsonProperty 注解使用
 */
@Slf4j
public class JsonPropertyTest {

    /**
     * 内部类
     */
    public class Student {

        @JsonProperty("id")
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("name")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    @Test
    public void test() throws JsonProcessingException {
        Student student = new Student();
        student.setId(1);
        student.setName("囧囧");

        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}