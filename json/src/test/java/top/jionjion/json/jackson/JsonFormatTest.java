package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author Jion
 * \@JsonFormat 注解使用
 */
@Slf4j
public class JsonFormatTest {

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

        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
        private Date birthday;

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }
    }

    @Test
    public void test() throws JsonProcessingException {
        Student student = new Student();
        student.setName("囧囧");
        student.setBirthday(new Date());

        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}