package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Jion
 * \@JsonView 注解使用
 */
@Slf4j
public class JsonViewTest {

    /**
     * 内部类
     */
    public class Student {

        @JsonView(Views.hide.class)
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @JsonView(Views.show.class)
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    @Test
    public void test() throws JsonProcessingException {
        Student student = new Student();
        student.setId(1);
        student.setName("囧囧");

        String result = new ObjectMapper()
                .writerWithView(Views.show.class)
                .writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}

/** 视图类,是否显示隐藏 */
class Views{
    public class show{

    }

    public class hide{

    }
}