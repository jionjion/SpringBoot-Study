package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author Jion
 * \@JsonIgnoreType 注解使用
 */
@Slf4j
public class JsonIgnoreTypeTest {

    /**
     * 内部类
     */
    public class Student {

        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private Info info;

        public Info getInfo() {
            return info;
        }

        public void setInfo(Info info) {
            this.info = info;
        }
    }

    @JsonIgnoreType
    public class Info{
        String address;

        String postcode;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public Info(String address, String postcode) {
            this.address = address;
            this.postcode = postcode;
        }
    }

    @Test
    public void test() throws JsonProcessingException {
        Student student = new Student();
        student.setId(1);
        student.setName("囧囧");
        Info info = new Info("上海","00001");
        student.setInfo(info);

        String result = new ObjectMapper().writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}
