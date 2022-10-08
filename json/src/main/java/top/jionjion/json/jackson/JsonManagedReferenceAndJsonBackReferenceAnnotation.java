package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

/**
 * .@JsonManagedReference 和 @sonBackReferenceTest 注解使用
 *
 * @author Jion
 */
@SuppressWarnings("unused")
public class JsonManagedReferenceAndJsonBackReferenceAnnotation {

    /**
     * 一方,学生
     */
    static class Student {

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
    static class Score {

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
}