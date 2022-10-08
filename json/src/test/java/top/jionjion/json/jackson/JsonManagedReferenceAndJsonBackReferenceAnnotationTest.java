package top.jionjion.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * .@JsonManagedReference 和 @sonBackReferenceTest 注解使用
 *
 * @author Jion
 */
@Slf4j
class JsonManagedReferenceAndJsonBackReferenceAnnotationTest {

    @Test
    void test() throws JsonProcessingException {
        // 一方
        JsonManagedReferenceAndJsonBackReferenceAnnotation.Student student = new JsonManagedReferenceAndJsonBackReferenceAnnotation.Student();
        student.setId(1);
        student.setName("囧囧");
        // 多方
        JsonManagedReferenceAndJsonBackReferenceAnnotation.Score chinese = new JsonManagedReferenceAndJsonBackReferenceAnnotation.Score();
        chinese.setSubject("语文");
        chinese.setResult("100");
        chinese.setStudent(student);
        JsonManagedReferenceAndJsonBackReferenceAnnotation.Score math = new JsonManagedReferenceAndJsonBackReferenceAnnotation.Score();
        math.setSubject("数学");
        math.setResult("99");
        math.setStudent(student);
        // 一方去维护多方
        List<JsonManagedReferenceAndJsonBackReferenceAnnotation.Score> scores = new ArrayList<>();
        scores.add(chinese);
        scores.add(math);
        student.setScores(scores);

        // 输出
        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}