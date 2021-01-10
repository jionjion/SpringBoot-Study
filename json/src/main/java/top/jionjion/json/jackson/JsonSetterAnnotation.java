package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * .@JsonSetter 类的测试
 *
 * @author Jion
 */
public class JsonSetterAnnotation {

    private Integer id;

    @JsonSetter("name")
    private String name;

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
        return "JsonSetterTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
