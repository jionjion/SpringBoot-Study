package top.jionjion.json.jackson;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * .@JsonGetter 注解使用
 *
 * @author Jion
 */
@SuppressWarnings("unused")
public class JsonGetterAnnotation {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
