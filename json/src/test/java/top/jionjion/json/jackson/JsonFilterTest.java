package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author Jion
 * \@JsonFilter 注解使用
 */
@Slf4j
public class JsonFilterTest {

    /**
     * 内部类
     */
    @JsonFilter("jsonFilter")
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

        // 过滤器
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("jsonFilter", // 过滤器名称
                        SimpleBeanPropertyFilter.filterOutAllExcept("name") // 仅允许输出的类
                );

        // 输出
        String result = new ObjectMapper()
                .writer(filters)
                .writeValueAsString(student);

        assertNotNull(result);
        log.info(result);
    }
}