package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * .@JsonPropertyOrder 注解使用
 *
 * @author Jion
 */
@SuppressWarnings("unused")
@JsonPropertyOrder({"id", "name"})
public class JsonPropertyOrderAnnotation {

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
}
