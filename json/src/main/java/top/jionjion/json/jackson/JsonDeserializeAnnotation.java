package top.jionjion.json.jackson;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.extern.slf4j.Slf4j;
import top.jionjion.json.jackson.format.JsonFormatDeserializer;

import java.util.Date;

/**
 * .@JsonDeserialize 注解使用
 *
 * @author Jion
 */
@Slf4j
public class JsonDeserializeAnnotation {

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

    /**
     * 指定日期格式化类
     */
    @JsonDeserialize(using = JsonFormatDeserializer.class)
    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "JsonDeserializeAnnotation{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}