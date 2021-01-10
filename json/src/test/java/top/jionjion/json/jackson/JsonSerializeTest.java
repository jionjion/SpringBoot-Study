package top.jionjion.json.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author Jion
 * \@JsonSerialize 注解使用
 */
@Slf4j
public class JsonSerializeTest {

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

        private Date birthday;

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        @JsonSerialize(using = JsonDataFormat.class)
        public Date getBirthday() {
            return birthday;
        }
    }

    /** 默认无参构造 */
    public JsonSerializeTest(){
        super();
    }


    @Test
    public void test() throws JsonProcessingException {
        Student student = new Student();
        student.setName("囧囧");
        student.setBirthday(new Date());

        String result = new ObjectMapper()
                .writeValueAsString(student);
        assertNotNull(result);
        log.info(result);
    }
}

/**
 * 格式化类,不能使用内部类.因此采用共有类
 */
class JsonDataFormat extends StdSerializer<Date> {

    /** 必须有无参数的构造方法 */
    public JsonDataFormat(){
        this(null);
    }

    /** 重写构造方法 */
    public JsonDataFormat(Class<Date> t){
        super(t);
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        // 日期格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 格式结果
        jsonGenerator.writeString(simpleDateFormat.format(date));
    }
}