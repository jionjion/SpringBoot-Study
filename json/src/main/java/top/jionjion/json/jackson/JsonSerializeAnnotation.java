package top.jionjion.json.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.extern.slf4j.Slf4j;
import top.jionjion.json.jackson.format.JsonFormatSerializer;

import java.util.Date;

/**
 * .@JsonSerialize 注解使用
 *
 * @author Jion
 */
@Slf4j
public class JsonSerializeAnnotation {

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

    @JsonSerialize(using = JsonFormatSerializer.class)
    public Date getBirthday() {
        return birthday;
    }
}
