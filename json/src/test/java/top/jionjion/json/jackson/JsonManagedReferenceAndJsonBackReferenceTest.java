package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author Jion
 * \@JsonManagedReference 和 \@sonBackReferenceTest 注解使用
 */
@Slf4j
public class JsonManagedReferenceAndJsonBackReferenceTest {


    @Test
    public void test() throws JsonProcessingException {
        // 一方
        Student student = new Student();
        student.setId(1);
        student.setName("囧囧");
        // 多方
        Score chinese = new Score();
        chinese.setSubject("语文");
        chinese.setResult("100");
        chinese.setStudent(student);
        Score math = new Score();
        math.setSubject("数学");
        math.setResult("99");
        math.setStudent(student);
        // 一方去维护多方
        List<Score> scores = new ArrayList<>();
        scores.add(chinese);
        scores.add(math);
        student.setScores(scores);

        // 输出
        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}


/**
 * 一方,学生
 */
class Student {

    private Integer id;

    private String name;

    @JsonBackReference
    public List<Score> scores;

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

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}


/**
 * 多方,成绩方
 */
class Score {

    private String subject;

    private String result;

    @JsonManagedReference
    private Student student;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}