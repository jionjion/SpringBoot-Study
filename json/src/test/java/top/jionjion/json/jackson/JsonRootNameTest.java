package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author Jion
 * \@JsonRootName 注解使用
 */
@Slf4j
public class JsonRootNameTest {

    /**
     * 内部类
     */
    @JsonRootName(value = "student")
    public class Student {

        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

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

        String result = new ObjectMapper()
                .enable(SerializationFeature.WRAP_ROOT_VALUE)
                .writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}
