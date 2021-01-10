package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * .@JsonValue 注解使用
 *
 * @author Jion
 */
public class JsonValueAnnotation {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;

    @JsonValue
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
