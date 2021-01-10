package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonRawValue;

/**
 * .@JsonRawValue 注解使用
 *
 * @author Jion
 */
public class JsonRawValueAnnotation {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String info;

    @JsonRawValue
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
