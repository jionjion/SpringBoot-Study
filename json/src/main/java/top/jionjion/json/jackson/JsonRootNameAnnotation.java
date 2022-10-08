package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * .@JsonRootName 注解使用
 *
 * @author Jion
 */
@SuppressWarnings("unused")
@JsonRootName(value = "student")
public class JsonRootNameAnnotation {

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
