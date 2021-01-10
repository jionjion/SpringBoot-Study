package top.jionjion.json.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Jion
 * \@JsonDeserialize 注解使用
 */
@Slf4j
public class JsonDeserializeTest {

    /**
     * 内部类
     */
    public static class Student {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private Date birthday;

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        @JsonDeserialize(using = BeanDataFormat.class)
        public Date getBirthday() {
            return birthday;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", birthday=" + birthday +
                    '}';
        }
    }

    /** 默认无参构造 */
    public JsonDeserializeTest(){
        super();
    }


    @Test
    public void test() throws IOException {

        String json = "{\n" +
                "  \"name\": \"囧囧\",\n" +
                "  \"birthday\": \"2019-01-01 12:00:00\"\n" +
                "}";

        Student student = new ObjectMapper()
                .readerFor(Student.class)
                .readValue(json);

        assertNotNull(student);
        log.info(student.toString());
    }
}

/**
 * 格式化类,不能使用内部类.因此采用共有类
 */
class BeanDataFormat extends StdDeserializer<Date> {

    /** 必须有无参数的构造方法 */
    public BeanDataFormat(){
        this(null);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        // 日期格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获得JSON属性值
        String date = jsonParser.getText();
        // 格式结果
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /** 重写构造方法 */
    public BeanDataFormat(Class<Date> t){
        super(t);
    }
}