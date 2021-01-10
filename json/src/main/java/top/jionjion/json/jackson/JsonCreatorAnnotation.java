package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * .@JsonCreator 类的测试
 *
 * @author Jion
 */
public class JsonCreatorAnnotation {

    private Integer id;

    private String name;

    @JsonCreator
    public JsonCreatorAnnotation(@JsonProperty("id") Integer id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JsonCreatorAnnotation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
