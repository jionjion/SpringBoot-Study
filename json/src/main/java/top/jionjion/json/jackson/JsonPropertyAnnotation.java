package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * .@JsonProperty 注解使用
 *
 * @author Jion
 */
public class JsonPropertyAnnotation {

    @JsonProperty("id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}