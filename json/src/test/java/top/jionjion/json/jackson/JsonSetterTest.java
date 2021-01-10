package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author Jion
 * \@JsonSetter 类的测试
 */
@Slf4j
public class JsonSetterTest {

    public static class Student {


        private Integer id;

        @JsonSetter("name")
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void test() throws IOException {
        String json = "{\n" +
                "  \"id\":\"1\",\n" +
                "  \"name\": \"囧囧\"\n" +
                "}";

        Student student = new ObjectMapper()
                .readerFor(Student.class)
                .readValue(json);

        assertNotNull(student);
        log.info(student.toString());
    }
}
