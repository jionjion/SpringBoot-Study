package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Jion
 * \@JsonAnyGetter 注解使用
 */
@Slf4j
public class JsonAnyGetterTest {


    /**
     * 内部类
     */
    public class Student {

        private Map<String, String> info = new HashMap<>();

        // 会将Map中的属性作为同级进行序列化
        @JsonAnyGetter
        public Map<String, String> getInfo() {
            return info;
        }

        private Map<String, String> score = new HashMap<>();

        // 会将Map中的属性作为嵌套进行序列化
        @JsonAnyGetter(enabled = false)
        public Map<String, String> getScore() {
            return score;
        }
    }


    @Test
    public void test() throws JsonProcessingException {
        Student student = new Student();
        student.getInfo().put("姓名", "囧囧");
        student.getInfo().put("学号", "001");
        student.getScore().put("语文", "100");
        student.getScore().put("数学", "99");

        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}
