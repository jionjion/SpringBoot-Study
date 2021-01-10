package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jion
 * \@JsonAnySetter 类的测试
 */
@Slf4j
public class JsonAnySetterTest {

    public static class Student {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private Map<String, String> info = new HashMap<>();

        public Map<String, String> getInfo() {
            return info;
        }

        public void setInfo(Map<String, String> info) {
            this.info = info;
        }

        // 会将Map中的属性作为同级进行反序列化
        @JsonAnySetter
        public void addInfo(String key, String value) {
            info.put(key, value);
        }

        private Map<String, String> score = new HashMap<>();


        public void setScore(Map<String, String> score) {
            this.score = score;
        }

        // 会将Map中的属性作为嵌套进行反序列化
        @JsonAnySetter(enabled = false)
        public void addScore(String key, String value) {
            score.put(key, value);
        }

        public Map<String, String> getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", info=" + info +
                    ", score=" + score +
                    '}';
        }
    }

    @Test
    public void test() throws IOException {
        String json = "{\n" +
                "  \"name\": \"囧囧\",\n" +
                "  \"address\":\"上海\",\n" +
                "  \"age\": \"23\",\n" +
                "  \"score\": {\n" +
                "    \"语文\":\"100\",\n" +
                "    \"数学\": \"99\"\n" +
                "  }\n" +
                "}";

        Student student = new ObjectMapper()
                .readerFor(Student.class)
                .readValue(json);

        assertNotNull(student);
        log.info(student.toString());
    }
}
