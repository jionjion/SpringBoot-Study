package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author Jion
 * \@JsonCreator 类的测试
 */
@Slf4j
public class JsonCreatorTest {

    public static class Student {

        private Integer id;

        private String name;

        @JsonCreator
        public Student(@JsonProperty("id") Integer id, @JsonProperty("name") String name) {
            this.id = id;
            this.name = name;
        }


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
