package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author Jion
 * \@JsonRawValue 注解使用
 */
@Slf4j
public class JsonRawValueTest {

    /**
     * 内部类
     */
    public class Student {


        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String info;

        @JsonRawValue
        public String getInfo() {
            return info;
        }
        public void setInfo(String info) {
            this.info = info;
        }
    }

    @Test
    public void test() throws JsonProcessingException {
        Student student = new Student();
        student.setName("囧囧");
        // JSON字符串
        student.setInfo("{\"地址\":\"上海\",\"年龄\":\"23\"}");

        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}
