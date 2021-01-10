package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author Jion
 * \@JacksonInject 类的测试
 */
@Slf4j
public class JacksonInjectTest {

    public static class Student {

        @JacksonInject
        private Integer id;

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
                "  \"name\": \"囧囧\"\n" +
                "}";
        // 提供的绑定变量
        InjectableValues inject = new InjectableValues.Std().addValue(Integer.class, 1);
        // 变量赋值,并指定读取的类
        Student student = new ObjectMapper()
                .reader(inject)
                .forType(Student.class)
                .readValue(json);

        assertNotNull(student);
        log.info(student.toString());
    }
}
